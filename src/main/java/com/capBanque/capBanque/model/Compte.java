package com.capBanque.capBanque.model;

import com.capBanque.capBanque.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorColumn(name= "TYPE_CPT", discriminatorType = DiscriminatorType.STRING, length = 50)
public abstract class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compteId;
    private Long accountNumber;
    private Double balance = 0.0;
    private Date creationDate = new Date();

}
