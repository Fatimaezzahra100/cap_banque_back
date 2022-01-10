package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    private Double overdraft;

    public CompteCourant(User user) {
        super(user);
        this.setBalance(500.0);

    }


}
