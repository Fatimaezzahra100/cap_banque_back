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
@DiscriminatorValue("IN")
public class OperationInterne extends Operation{


    private Long compteReceiverId;

    public OperationInterne(Long amount, Long compteSenderId, Frequence frequence, Long compteReceiverId) {
        super(amount, compteSenderId, frequence);
        this.compteReceiverId = compteReceiverId;
    }
}
