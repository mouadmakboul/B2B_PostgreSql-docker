package com.example.B2B.Controllers;

import com.example.B2B.Entities.contratEntity;
import com.example.B2B.Services.ContratService;
import com.example.B2B.Exceptions.ContratException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService contratService;

    @Autowired
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public ResponseEntity<contratEntity> createContrat(@RequestBody contratEntity contrat) {
        try {
            contratEntity createdContrat = contratService.createContrat(contrat);
            return new ResponseEntity<>(createdContrat, HttpStatus.CREATED);
        } catch (ContratException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<contratEntity> getContratById(@PathVariable long id) {
        try {
            contratEntity contrat = contratService.getContratById(id);
            return new ResponseEntity<>(contrat, HttpStatus.OK);
        } catch (ContratException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<contratEntity>> getAllContrats() {
        List<contratEntity> contrats = contratService.getAllContrats();
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<contratEntity> updateContrat(@PathVariable long id, @RequestBody contratEntity contrat) {
        try {
            contrat.setId(id);
            contratEntity updatedContrat = contratService.updateContrat(contrat);
            return new ResponseEntity<>(updatedContrat, HttpStatus.OK);
        } catch (ContratException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable long id) {
        try {
            contratService.deleteContrat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ContratException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-entreprise/{entrepriseId}")
    public ResponseEntity<List<contratEntity>> getContratsByEntreprise(@PathVariable long entrepriseId) {
        try {
            List<contratEntity> contrats = contratService.getContratsByEntreprise(entrepriseId);
            return new ResponseEntity<>(contrats, HttpStatus.OK);
        } catch (ContratException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
