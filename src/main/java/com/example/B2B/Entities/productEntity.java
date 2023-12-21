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

public class productEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private long id;
    private String Description;
    private int prix;
    private String Quantite;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private entrepriseEntity entreprise;

    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY)
    private List<categoryproductEntity> categories;

    @ManyToOne
    @JoinColumn(name = "ligne_commande_id")
    private lignecommandeEntity ligne_commande;


    @ManyToOne
    @JoinColumn(name = "catalogue")
    private catalogueEntity catalogue;

}
