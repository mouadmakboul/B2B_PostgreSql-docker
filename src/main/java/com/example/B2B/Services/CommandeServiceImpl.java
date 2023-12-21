// CommandeServiceImpl.java
package com.example.B2B.Services;

import com.example.B2B.Entities.commandeEntity;

import com.example.B2B.Exceptions.CommandeException;
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
        // Exemple de vérification et de lancement d'une exception
        if (commande.getMontantTotal() <= 0) {
            throw new CommandeException("Le montant total de la commande doit être supérieur à zéro.");
        }

        return commandeRepository.save(commande);
    }


    @Override
    public commandeEntity getCommandeById(long id) {
        return commandeRepository.findById(id).orElseThrow(() -> new CommandeException("Commande introuvable avec l'ID : " + id));
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

        return commandeRepository.findByEntrepriseId(entrepriseId);
    }
}
