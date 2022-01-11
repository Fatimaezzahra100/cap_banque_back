package com.capBanque.capBanque.controller;
import com.capBanque.capBanque.model.Compte;
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

    @PostMapping("/save")
    public ResponseEntity<Compte> addNewCompte(@RequestBody Compte compte){
        Compte compte1 = compteService.saveCompte(compte);
        return new ResponseEntity<>(compte1,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable("id") Long id){
        Compte compte = compteService.consultAccount(id);
        return new ResponseEntity<Compte>(compte,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteC (Compte compte){
         compteService.deleteCompte(compte);
    }

    @GetMapping("")
    public ResponseEntity<List<Compte>> getAllComptes(){
        List<Compte> comptes = compteService.findAllCompte();
        return  new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Compte> updateC (@RequestBody Compte compte){
        Compte compte1 = compteService.updateCompte(compte);
        return new ResponseEntity<>(compte1, HttpStatus.OK);
    }




}
