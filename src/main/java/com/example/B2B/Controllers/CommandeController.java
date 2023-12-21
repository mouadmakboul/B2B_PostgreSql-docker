package com.example.B2B.Controllers;

import com.example.B2B.Entities.commandeEntity;
import com.example.B2B.Services.CommandeService;
import com.example.B2B.Exceptions.CommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping
    public ResponseEntity<commandeEntity> createCommande(@RequestBody commandeEntity commande) {
        try {
            commandeEntity createdCommande = commandeService.createCommande(commande);
            return new ResponseEntity<>(createdCommande, HttpStatus.CREATED);
        } catch (CommandeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<commandeEntity> getCommandeById(@PathVariable long id) {
        try {
            commandeEntity commande = commandeService.getCommandeById(id);
            return new ResponseEntity<>(commande, HttpStatus.OK);
        } catch (CommandeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<commandeEntity>> getAllCommandes() {
        List<commandeEntity> commandes = commandeService.getAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<commandeEntity> updateCommande(@PathVariable long id, @RequestBody commandeEntity commande) {
        try {
            commande.setId(id);
            commandeEntity updatedCommande = commandeService.updateCommande(commande);
            return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
        } catch (CommandeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable long id) {
        try {
            commandeService.deleteCommande(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CommandeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-entreprise/{entrepriseId}")
    public ResponseEntity<List<commandeEntity>> getCommandesByEntreprise(@PathVariable long entrepriseId) {
        try {
            List<commandeEntity> commandes = commandeService.getCommandesByEntreprise(entrepriseId);
            return new ResponseEntity<>(commandes, HttpStatus.OK);
        } catch (CommandeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
