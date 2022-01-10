package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationInterne extends Operation{

    @ManyToOne
    @JoinColumn(name ="compte_receiver_id")
    private Compte compteReceiver;

    public OperationInterne(Long amount, Compte compteSender, Frequence frequence, Compte compteReceiver) {
        super(amount, compteSender, frequence);
        this.compteReceiver = compteReceiver;
    }
}
