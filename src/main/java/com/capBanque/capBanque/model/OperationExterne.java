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
public class OperationExterne extends Operation{

    @ManyToOne
    @JoinColumn(name ="compte_receiver_id")
    private Rib ribReceiver;

    public OperationExterne(Long amount, Compte compteSender, Frequence frequence, Rib ribReceiver) {
        super(amount, compteSender, frequence);
        this.ribReceiver = ribReceiver;
    }
}

