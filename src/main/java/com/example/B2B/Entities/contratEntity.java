package com.example.B2B.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class contratEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contrat_id", nullable = false)
    private long id;

    private String ChifrreAffaire;

    private String DureeContrat;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private entrepriseEntity entreprise;

    @OneToOne
    @JoinColumn(name = "client_id")
    private clientEntity client;

    @OneToOne
    @JoinColumn(name = "client_id")
    @PrimaryKeyJoinColumn
    private catalogueEntity catalogue;


}
