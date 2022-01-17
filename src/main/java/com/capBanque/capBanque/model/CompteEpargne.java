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
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
    private Double rate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CompteEpargne(User user, Double rate) {
        super();
        this.user = user;
        this.rate = rate;
    }
}
