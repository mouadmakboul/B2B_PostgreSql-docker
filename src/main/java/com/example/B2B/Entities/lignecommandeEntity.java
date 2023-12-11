package com.example.B2B.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class lignecommandeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lignecommande_id", nullable = false)
    private long id;

    private String Quantite;
    private String PrixUnitaire;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private commandeEntity commande;

    @OneToMany(mappedBy = "ligne_commande" ,fetch = FetchType.LAZY)
    private List<productEntity> products;



}
