package com.capBanque.capBanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Locale;
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
        Random r = new Random();
        char c1 = (char) (r.nextInt(26) + 'a');
        char c2 = (char) (r.nextInt(26) + 'a');
        String gen = (String.valueOf(c1))+(String.valueOf(c2));

        String chiffres = "";
        for(int i=0; i<23; i++){
            int chiffre = 0 + (int)(Math.random() * ((9 - 0) + 1));
            chiffres += String.valueOf(chiffre);
        }

        iban += gen.toUpperCase() + chiffres;
        return iban;

    }
}
