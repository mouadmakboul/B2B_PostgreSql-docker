package com.example.B2B.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data


public class clientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private long id;

    private String nom_client;
    private String adresse_client;

    public clientEntity(long id, String nom_client, String adresse_client) {
        this.id = id;
        this.nom_client = nom_client;
        this.adresse_client = adresse_client;
    }

    @OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
    private List<representantEntity> representants;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private contratEntity contrat;



}
