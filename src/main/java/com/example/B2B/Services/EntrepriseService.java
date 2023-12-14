package com.example.B2B.Services;

import com.example.B2B.Entities.*;

import java.util.List;

public interface EntrepriseService {

    // CRUD operations
    entrepriseEntity createEntreprise(entrepriseEntity entreprise);
    entrepriseEntity getEntrepriseById(long id);
    List<entrepriseEntity> getAllEntreprises();
    entrepriseEntity updateEntreprise(entrepriseEntity entreprise);
    void deleteEntreprise(long id);

    // Fetch related entities

}
