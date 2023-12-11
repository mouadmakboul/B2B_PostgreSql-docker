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
    public String adresse_client;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private entrepriseEntity entreprise;

    @OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
    private List<representantEntity> representants;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private contratEntity contrat;



}
