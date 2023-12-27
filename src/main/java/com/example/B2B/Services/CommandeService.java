package com.example.B2B.Services;

import com.example.B2B.Entities.commandeEntity;

import java.util.List;

public interface CommandeService {
    commandeEntity createCommande(commandeEntity commande);
    commandeEntity getCommandeById(long id);
    List<commandeEntity> getAllCommandes();
    commandeEntity updateCommande(commandeEntity commande);
    void deleteCommande(long id);

    // Ajoutez d'autres méthodes spécifiques au besoin

}