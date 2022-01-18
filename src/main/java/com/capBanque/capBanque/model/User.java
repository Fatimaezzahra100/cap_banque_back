package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String password;

    @OneToMany
    private List<CompteEpargne> comptesEpargne;
    private Long compteCourantId;
    private Long ribId;
    private Long tel;
    @OneToMany
    private List<Operation> operations;

    public User(String userName, String lastName, String firstName, String email, String address, Long tel) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.tel = tel;
        CompteCourant compteCourant = new CompteCourant(this.userId);
        this.compteCourantId = compteCourant.getCompteId();
        Rib rib = new Rib(this.userId);
        this.ribId = rib.getRibId();
    }

    public User(){
        CompteCourant compteCourant = new CompteCourant(this.userId);
        this.compteCourantId = compteCourant.getCompteId();
        Rib rib = new Rib(this.userId);
        this.ribId = rib.getRibId();
    }
}
