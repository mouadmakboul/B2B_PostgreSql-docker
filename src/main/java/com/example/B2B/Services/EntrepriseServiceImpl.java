package com.example.B2B.Services;

import com.example.B2B.Entities.entrepriseEntity;

import com.example.B2B.Exceptions.EntrepriseException;
import com.example.B2B.Repositories.entrepriseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private final entrepriseRepo entrepriseRepository;


    @Autowired
    public EntrepriseServiceImpl(entrepriseRepo entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;

    }



    @Override
    public entrepriseEntity createEntreprise(entrepriseEntity entreprise) {
        return entrepriseRepository.save(entreprise);
    }


    @Override
    public entrepriseEntity getEntrepriseById(long id) {
        return entrepriseRepository.findById(id).orElseThrow(() -> new EntrepriseException("Entreprise introuvable avec l'ID : " + id));
    }

    @Override
    public List<entrepriseEntity> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public entrepriseEntity updateEntreprise(entrepriseEntity entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public void deleteEntreprise(long id) {
        entrepriseRepository.deleteById(id);
    }



}
