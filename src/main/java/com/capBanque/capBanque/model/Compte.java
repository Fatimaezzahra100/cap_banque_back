package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorColumn(name= "TYPE_CPT", discriminatorType = DiscriminatorType.STRING, length = 50)
public abstract class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compteId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Long accountNumber;
    private Double balance;
    private Date creationDate;

    public Compte(Long compteId, Long accountNumber, Double balance, User user, Date creationDate ) {
        super();
        this.compteId=getCompteId();
        this.accountNumber=getAccountNumber();
        this.balance=getBalance();
        this.user = getUser();
        this.creationDate = getCreationDate();
    }

    public Compte(User user) {
        super();
        this.user = user;
        this.creationDate = new Date();
    }
}
