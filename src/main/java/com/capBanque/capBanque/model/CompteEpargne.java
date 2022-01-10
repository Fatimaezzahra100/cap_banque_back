package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
    private Double rate;

    public CompteEpargne(User user, Double rate) {
        super(user);
        this.rate = rate;
    }
}
