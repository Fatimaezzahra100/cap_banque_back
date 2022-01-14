package com.capBanque.capBanque.controller;

import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.model.CompteEpargne;
import com.capBanque.capBanque.model.User;
import com.capBanque.capBanque.service.CompteService;
import com.capBanque.capBanque.service.UserService;
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

    @Autowired
    UserService userService;

    @PostMapping("comptes/savecc")
    public ResponseEntity<Compte> addNewCompteCourant(@RequestBody CompteCourant compte) {
        Compte compte1 = compteService.saveCompteCourant(compte);
        return new ResponseEntity<>(compte1, HttpStatus.CREATED);
    }

    @PostMapping("comptes/savece")
    public ResponseEntity<Compte> addNewCompteEpargne(@RequestBody CompteEpargne compte) {
        Compte compte1 = compteService.saveCompteEpagne(compte);
        return new ResponseEntity<>(compte1, HttpStatus.CREATED);
    }

    @GetMapping("comptes/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable("id") Long id) {
        Compte compte = compteService.findCompteById(id);
        return new ResponseEntity<Compte>(compte, HttpStatus.OK);
    }

    @DeleteMapping("comptes/delete")
    public void deleteC(@RequestBody Compte compte) {
        compteService.deleteCompte(compte);
    }

    @DeleteMapping("comptes/delete/{id}")
    public void deleteC(@PathVariable("id") Long id) {
        compteService.deleteCompteById(id);
    }

    @GetMapping("comptes/all")
    public ResponseEntity<List<Compte>> getAllComptes() {
        List<Compte> comptes = compteService.findAllCompte();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @PutMapping("comptes/updatecc/{id}")
    public ResponseEntity<Compte> updateCC(@RequestBody CompteCourant compte, @PathVariable("id") Long id) {
        Compte compte1 = compteService.updateCompteCourant(compte, id);
        return new ResponseEntity<>(compte1, HttpStatus.OK);
    }

    @PutMapping("comptes/updatece/{id}")
    public ResponseEntity<Compte> updateCE(@RequestBody CompteEpargne compte, @PathVariable("id") Long id) {
        Compte compte1 = compteService.updateCompteEpargne(compte, id);
        return new ResponseEntity<>(compte1, HttpStatus.OK);
    }

    //userController
    @PostMapping("users/save")
    public ResponseEntity<User> addNewUser (@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("users/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @DeleteMapping("users/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("users/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User user1 = userService.updateUser(user, id);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }


}
