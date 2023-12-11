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


public class categoryproductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_product_id", nullable = false)
    private long id;
    private String Nom;
    private String Description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private productEntity product;




}
