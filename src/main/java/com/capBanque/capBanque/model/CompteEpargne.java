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

@NoArgsConstructor
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

    private Double rate;

    public CompteEpargne( Double rate) {
        super();
        this.rate = rate;
    }
}
