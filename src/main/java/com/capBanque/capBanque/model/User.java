package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String address;

    @OneToMany(mappedBy = "user")
    private Collection<Compte> comptes;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name="RIB_id")
    private Rib rib;

    private Long tel;

    @OneToMany(mappedBy="compteSender")
    private Collection<Operation> operations;

    public User(String userName, String lastName, String firstName, String email, String address, Long tel) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.tel = tel;
    }
}
