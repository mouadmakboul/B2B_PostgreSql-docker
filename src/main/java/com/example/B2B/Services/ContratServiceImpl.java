// ContratServiceImpl.java
package com.example.B2B.Services;

import com.example.B2B.Entities.contratEntity;

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
        return contratRepository.save(contrat);
    }

    @Override
    public contratEntity getContratById(long id) {
        return contratRepository.findById(id).orElse(null);
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
