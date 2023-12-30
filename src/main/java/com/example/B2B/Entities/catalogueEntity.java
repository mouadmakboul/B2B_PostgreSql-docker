package com.example.B2B.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class catalogueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogue_id", nullable = false)
    private long id;
    @OneToOne(mappedBy = "catalogue", cascade = CascadeType.ALL)
    private contratEntity contrat;

    @ManyToMany(mappedBy = "catalogues")
    private Set<productEntity> produits;
}
