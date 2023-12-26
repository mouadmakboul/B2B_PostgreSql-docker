package com.example.B2B.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class entrepriseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Entreprise_id", nullable = false)
    private long id;
    @NotBlank(message = "Le champ 'Nom' ne peut pas être vide.")
    private String Nom;
    @NotBlank(message = "Le champ 'Adresse' ne peut pas être vide.")
    private String Adresse;

    @NotNull(message = "Le champ 'Tel' ne peut pas être nul.")
    private Number Tel;
    @jakarta.validation.constraints.Email
    @Email(message = "Le champ 'Email' doit être une adresse email valide.")
    @NotBlank(message = "Le champ 'Email' ne peut pas être vide.")
    private String Email;
    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<clientEntity> client;


    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<commandeEntity> commandes;

    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<productEntity> products;

    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<contratEntity> contrats;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Number getTel() {
        return Tel;
    }

    public void setTel(Number tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
