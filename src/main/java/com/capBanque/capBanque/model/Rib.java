package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rib implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ribId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String iban;
    private String bic;

    public Rib(User user) {
        this.user = user;
    }
}
