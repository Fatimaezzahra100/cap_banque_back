package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    private Double overdraft;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CompteCourant(User user) {
        super();
        this.user = user;
        this.overdraft = 0.0;
        this.setBalance(500.0);
    }




}
