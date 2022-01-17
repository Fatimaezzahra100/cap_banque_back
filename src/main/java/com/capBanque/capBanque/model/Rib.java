package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rib implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ribId;

    private Long userId;
    private String iban;
    private String bic = "CAPBFRPP";

    public Rib(Long userId) {
        this.userId = userId;
        this.iban = generateIban();

    }

    public String generateIban(){
        String iban = "FR";
        RandomString gen = new RandomString(2, ThreadLocalRandom.current());
        String chiffres = "";
        for(int i=0; i<23; i++){
            int chiffre = (int) Math.random();
            chiffres += String.valueOf(chiffre);
        }

        iban += gen + chiffres;
        return iban;

    }
}
