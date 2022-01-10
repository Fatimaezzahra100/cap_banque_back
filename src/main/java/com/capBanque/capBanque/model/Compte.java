package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorColumn(name= "TYPE_CPT", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compteId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long accountNumber;
    private Double balance;
    private Date creationDate;


    public Compte(User user) {
        this.user = user;
        this.creationDate = new Date();
    }
}
