package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name= "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;
    private Long amount;
    private Long compteSenderId;
    private Date operationDate = new Date();
    private Frequence frequence;

    public Operation(Long amount, Long compteSenderId, Frequence frequence) {
        this.amount = amount;
        this.compteSenderId = compteSenderId;
        this.frequence = frequence;
        this.operationDate = new Date();
    }
}
