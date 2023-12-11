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

public class representantEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "representant_id", nullable = false)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    @jakarta.validation.constraints.Email
    private String Email;
    private String password;


    @OneToMany(mappedBy = "representant" ,fetch = FetchType.LAZY)
    private List<commandeEntity> commandes;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private clientEntity client;


}
