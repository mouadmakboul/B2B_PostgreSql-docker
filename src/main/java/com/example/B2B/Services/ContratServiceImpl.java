// ContratServiceImpl.java
package com.example.B2B.Services;

import com.example.B2B.Entities.contratEntity;

import com.example.B2B.Exceptions.ContratException;
import com.example.B2B.Repositories.contratRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {

    private final contratRepo contratRepository;

    @Autowired
    public ContratServiceImpl(contratRepo contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public contratEntity createContrat(contratEntity contrat) {
        // Exemple de vérification et de lancement d'une exception
        if (contrat.getDureeContrat() <= 0) {
            throw new ContratException("La durée du contrat doit être supérieure à zéro.");
        }

        return contratRepository.save(contrat);
    }

    @Override
    public contratEntity getContratById(long id) {
        return contratRepository.findById(id).orElseThrow(() -> new ContratException("Contrat introuvable avec l'ID : " + id));
    }


    @Override
    public List<contratEntity> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public contratEntity updateContrat(contratEntity contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public List<contratEntity> getContratsByEntreprise(long entrepriseId) {

        return contratRepository.findByEntrepriseId(entrepriseId);
    }
}
