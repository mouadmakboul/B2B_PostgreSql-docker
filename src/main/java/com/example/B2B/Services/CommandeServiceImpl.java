// CommandeServiceImpl.java
package com.example.B2B.Services;

import com.example.B2B.Entities.commandeEntity;

import com.example.B2B.Repositories.commandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    private final commandeRepo commandeRepository;

    @Autowired
    public CommandeServiceImpl(commandeRepo commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public commandeEntity createCommande(commandeEntity commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public commandeEntity getCommandeById(long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<commandeEntity> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public commandeEntity updateCommande(commandeEntity commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public List<commandeEntity> getCommandesByEntreprise(long entrepriseId) {
        // Implémentez la logique pour récupérer les commandes par entreprise
        // Vous devrez probablement avoir une colonne "entreprise_id" dans votre table commandeEntity
        return commandeRepository.findByEntrepriseId(entrepriseId);
    }
}
