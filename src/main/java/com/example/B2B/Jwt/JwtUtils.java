package com.example.B2B.Jwt;


import com.example.B2B.Services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${airbnb.app.jwtSecret}")
    private String jwtSecret;

    @Value("${airbnb.app.jwtExpirationMs}")
    private Long jwtExpirationMs;

    @Value("${airbnb.app.jwtCookieName}")
    private String jwtCookie;

    @Value("${airbnb.app.jwtRefreshExpirationMs}") //ce que j ai ajouté
    private Long jwtRefreshExpirationMs;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }
    public String generateRefreshToken(UserDetailsImpl userPrincipal) {
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtRefreshExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }
    public String generateAccessTokenFromRefreshToken(String refreshToken) {
        // Extraire le nom d'utilisateur du token d'actualisation
        String username = getUserNameFromJwtToken(refreshToken);

        // Générer un nouveau token d'accès
        return generateTokenFromUsername(username);
    }


    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
               .setSubject(username)
                .setIssuedAt(new Date())
               .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    public ResponseCookie generateJwtCookieAndRefreshToken(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        String refreshToken = generateRefreshToken(userPrincipal);

        // Inclure le token d'actualisation comme valeur du cookie
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, refreshToken)
                .path("/api")
                .maxAge(24 * 60 * 60)
                .httpOnly(true)
                .build();
        return cookie;
    }
    public String validateAndRefreshJwtToken(String accessToken, String refreshToken) {
        try {
            // Vérifier si le token d'accès est valide
            Jwts.parserBuilder().setSigningKey(key()).build().parse(accessToken);

            // Si le token d'accès est valide, retournez-le
            return accessToken;
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());

            // Le token d'accès a expiré, essayez de rafraîchir en utilisant le token d'actualisation
            if (validateJwtToken(refreshToken)) {
                // Générer un nouveau token d'accès à partir du token d'actualisation
                return generateAccessTokenFromRefreshToken(refreshToken);
            }
        } catch (JwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        }

        return null;
    }

}
