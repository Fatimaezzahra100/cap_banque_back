package com.capBanque.capBanque.controller;

import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.model.CompteEpargne;
import com.capBanque.capBanque.repository.CompteRepository;
import com.capBanque.capBanque.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/banking")
public class bankController {

    @Autowired
    CompteService compteService;

    @PostMapping("/savecc")
    public ResponseEntity<Compte> addNewCompteCourant(@RequestBody CompteCourant compte) {
        Compte compte1 = compteService.saveCompteCourant(compte);
        return new ResponseEntity<>(compte1, HttpStatus.CREATED);
    }

    @PostMapping("/savece")
    public ResponseEntity<Compte> addNewCompteCourant(@RequestBody CompteEpargne compte) {
        Compte compte1 = compteService.saveCompteEpagne(compte);
        return new ResponseEntity<>(compte1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable("id") Long id) {
        Compte compte = compteService.findCompteById(id);
        return new ResponseEntity<Compte>(compte, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteC(@RequestBody Compte compte) {
        compteService.deleteCompte(compte);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteC(@PathVariable("id") Long id) {
        compteService.deleteCompteById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Compte>> getAllComptes() {
        List<Compte> comptes = compteService.findAllCompte();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @PutMapping("/updatecc/{id}")
    public ResponseEntity<Compte> updateCC(@RequestBody CompteCourant compte, @PathVariable("id") Long id) {
        Compte compte1 = compteService.updateCompteCourant(compte, id);
        return new ResponseEntity<>(compte1, HttpStatus.OK);
    }

    @PutMapping("/updatece/{id}")
    public ResponseEntity<Compte> updateCE(@RequestBody CompteEpargne compte, @PathVariable("id") Long id) {
        Compte compte1 = compteService.updateCompteEpargne(compte, id);
        return new ResponseEntity<>(compte1, HttpStatus.OK);
    }


}
