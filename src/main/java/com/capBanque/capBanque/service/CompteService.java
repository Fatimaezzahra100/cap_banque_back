package com.capBanque.capBanque.service;

import com.capBanque.capBanque.exeption.UserNotFoundException;
import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.model.CompteEpargne;
import com.capBanque.capBanque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public Compte findCompteById(Long id) {
        return compteRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "Account by id" + id + "was not found"));
    }

    public void deleteCompte(Compte compte) {
        compteRepository.delete(compte);
    }

    public void deleteCompteById(Long id) {
        compteRepository.deleteById(id);
    }

    public List<Compte> findAllCompte() {
        return compteRepository.findAll();
    }

    public Compte updateCompteCourant(CompteCourant compteCc, Long id) {
        Compte compteCourantToUpdate = findCompteById(id);
        compteCourantToUpdate.setAccountNumber(compteCc.getAccountNumber());
        compteCourantToUpdate.setBalance(compteCc.getBalance());
        return compteRepository.save(compteCourantToUpdate);
    }

    public Compte updateCompteEpargne (CompteEpargne compteCe, Long id) {
        Compte compteEpargneToUpdate = findCompteById(id);
        compteEpargneToUpdate.setAccountNumber(compteCe.getAccountNumber());
        compteEpargneToUpdate.setBalance(compteCe.getBalance());
        return compteRepository.save(compteEpargneToUpdate);
    }

    public Compte updateCompteEpargne(CompteEpargne compte) {
        return compteRepository.save(compte);
    }

    public Compte saveCompteCourant(CompteCourant compte) {
        return compteRepository.save(compte);
    }

    public Compte saveCompteEpagne(CompteEpargne compte) {
        return compteRepository.save(compte);
    }


}
