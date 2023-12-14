package com.example.B2B.Services;

import com.example.B2B.Entities.contratEntity;

import java.util.List;

public interface ContratService {
    contratEntity createContrat(contratEntity contrat);
    contratEntity getContratById(long id);
    List<contratEntity> getAllContrats();
    contratEntity updateContrat(contratEntity contrat);
    void deleteContrat(long id);

    // Ajoutez d'autres méthodes spécifiques au besoin
    List<contratEntity> getContratsByEntreprise(long entrepriseId);
}