package com.capBanque.capBanque.service;

import com.capBanque.capBanque.exeption.UserNotFoundException;
import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Compte consultAccount(Long id){
        return compteRepository.findById(id).orElseThrow(()-> new UserNotFoundException(
                "Account by id" +id+"was not found"));
    }

    public void deleteCompte(Compte compte){
        compteRepository.delete(compte);
    }

    public List<Compte> findAllCompte(){
        return compteRepository.findAll();
    }

    public Compte updateCompte(Compte compte, Long id){
        Compte compteToUpdate = consultAccount(id);
        compteToUpdate.setBalance(compte.getBalance());
        compteToUpdate.setAccountNumber(compte.getAccountNumber());
        return compteToUpdate;
    }



}
