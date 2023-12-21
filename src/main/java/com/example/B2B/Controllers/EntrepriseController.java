package com.example.B2B.Controllers;

import com.example.B2B.Entities.entrepriseEntity;
import com.example.B2B.Services.EntrepriseService;
import com.example.B2B.Exceptions.EntrepriseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @PostMapping
    public ResponseEntity<entrepriseEntity> createEntreprise(@RequestBody entrepriseEntity entreprise) {
        try {
            entrepriseEntity createdEntreprise = entrepriseService.createEntreprise(entreprise);
            return new ResponseEntity<>(createdEntreprise, HttpStatus.CREATED);
        } catch (EntrepriseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<entrepriseEntity> getEntrepriseById(@PathVariable long id) {
        try {
            entrepriseEntity entreprise = entrepriseService.getEntrepriseById(id);
            return new ResponseEntity<>(entreprise, HttpStatus.OK);
        } catch (EntrepriseException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<entrepriseEntity>> getAllEntreprises() {
        List<entrepriseEntity> entreprises = entrepriseService.getAllEntreprises();
        return new ResponseEntity<>(entreprises, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<entrepriseEntity> updateEntreprise(@PathVariable long id, @RequestBody entrepriseEntity entreprise) {
        try {
            entreprise.setId(id);
            entrepriseEntity updatedEntreprise = entrepriseService.updateEntreprise(entreprise);
            return new ResponseEntity<>(updatedEntreprise, HttpStatus.OK);
        } catch (EntrepriseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable long id) {
        try {
            entrepriseService.deleteEntreprise(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntrepriseException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
