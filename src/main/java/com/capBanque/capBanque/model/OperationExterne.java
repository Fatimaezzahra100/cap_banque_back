package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("EX")
public class OperationExterne extends Operation{

    @ManyToOne
    @JoinColumn(name ="ribReceiverId")
    private Rib ribReceiver;

    public OperationExterne(Long amount, Long compteSender, Frequence frequence, Rib ribReceiver) {
        super(amount, compteSender, frequence);
        this.ribReceiver = ribReceiver;
    }
}

