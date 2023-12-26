package com.example.B2B.Exceptions;

import org.springframework.http.HttpStatusCode;

public class EntrepriseException extends RuntimeException {

    public EntrepriseException(String message) {
        super(message);
    }


}
