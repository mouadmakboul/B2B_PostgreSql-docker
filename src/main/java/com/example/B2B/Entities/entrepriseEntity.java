package com.example.B2B.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

public class entrepriseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Entreprise_id", nullable = false)
    private long id;
    private String Nom;
    private String Adresse;
    private Number Tel;
    @jakarta.validation.constraints.Email
    private String Email;
    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<clientEntity> client;


    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<commandeEntity> commandes;

    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<productEntity> products;

    @OneToMany(mappedBy = "entreprise" ,fetch = FetchType.LAZY)
    private List<contratEntity> contrats;




}
