package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    private Double overdraft;

    private Long userId;

    public CompteCourant(Long userId) {
        super();
        this.userId = userId;
        this.overdraft = 0.0;
        this.setBalance(500.0);
    }

    public CompteCourant() {
        super();
        this.overdraft = 0.0;
        this.setBalance(500.0);
    }




}
