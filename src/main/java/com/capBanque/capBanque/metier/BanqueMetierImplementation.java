package com.capBanque.capBanque.metier;

import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.repository.CompteRepository;
import com.capBanque.capBanque.repository.OperationRepository;
import com.capBanque.capBanque.service.CompteService;
import com.capBanque.capBanque.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanqueMetierImplementation implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository OperationRepository;

    @Autowired
    private CompteService compteService;

    @Autowired
    private OperationService operationService;



    @Override
    public void verser(Long compteId, double montant) {
        Compte compte = compteService.findCompteById(compteId);
        // mettre à jour le solde
        compte.setBalance(compte.getBalance() + montant);
        compteRepository.save(compte);
    }

    @Override
    public void retirer(Long compteId, double montant) {
        Compte compte = compteService.findCompteById(compteId);
        if (compte instanceof CompteCourant){
            //On ne permet pas un découvert > 1000euro
            if(compte.getBalance() == 0 && ((CompteCourant) compte).getOverdraft() + montant > 1000){
                throw new RuntimeException(" Insufficient balance ");
            } else {
                //si solde < montant on augmente le découvert et solde passe à 0 ...
                if(montant > compte.getBalance()){
                    double montantRestant = montant - compte.getBalance();
                    if (((CompteCourant) compte).getOverdraft() + montantRestant > 1000){
                        throw new RuntimeException(" Insufficient balance ");
                    }
                    compte.setBalance(0.0);
                    ((CompteCourant) compte).setOverdraft(((CompteCourant) compte).getOverdraft() + montantRestant);
                    compteRepository.save(compte);
                }
                //... sinon on retire le montant au sole
                else {
                    double solde = compte.getBalance();
                    compte.setBalance(solde - montant);
                    compteRepository.save(compte);
                }

            }
        } else {
            //pour un compte épargne pas de découvert autorisé
            if(montant < compte.getBalance()) {
                compte.setBalance(compte.getBalance() - montant);
                compteRepository.save(compte);
            } else {
                throw new RuntimeException(" Insufficient balance ");
            }
        }

    }

    @Override
    public void virement(Long compteSenderId, Long compteReceiverId, double montant) {
        if (compteSenderId.equals(compteReceiverId))
            throw new RuntimeException("Operation impossible in the same compte ");
        retirer(compteSenderId, montant);
        verser(compteReceiverId, montant);

    }
}
