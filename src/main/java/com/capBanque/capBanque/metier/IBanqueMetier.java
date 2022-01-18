package com.capBanque.capBanque.metier;

import com.capBanque.capBanque.model.Compte;

public interface IBanqueMetier {

    public void verser (Long compteId, double montant);
    public void retirer (Long compteId, double montant);
    public void virement (Long compteSenderId, Long compteReceiverId, double montant);
}
