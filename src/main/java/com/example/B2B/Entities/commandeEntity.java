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

public class commandeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id", nullable = false)
    private long id;
    private long MontantTotal;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private entrepriseEntity entreprise;

    @OneToMany(mappedBy = "commande" ,fetch = FetchType.LAZY)
    private List<lignecommandeEntity> lignecommandes;


    @ManyToOne
    @JoinColumn(name = "represantant_id")
    private representantEntity representant;

}
