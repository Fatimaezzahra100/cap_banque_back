package com.capBanque.capBanque;

import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.CompteCourant;
import com.capBanque.capBanque.model.CompteEpargne;
import com.capBanque.capBanque.model.User;
import com.capBanque.capBanque.repository.CompteRepository;
import com.capBanque.capBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CapBanqueApplication {


	public static void main(String[] args) {
		SpringApplication.run(CapBanqueApplication.class, args);
	}




	@Bean
	CommandLineRunner runner(UserRepository userRepository, CompteRepository compteRepository){
		return args -> {
			//User user  = new User("Syd","Okou","Sydney","sydney@gmail.com","France", 0611111111L);
			//userRepository.save(user);

			//CompteCourant compteCourant = new CompteCourant(userRepository.getById(1L));
			//CompteEpargne compteEpargne = new CompteEpargne(userRepository.getById(1L), 5.0);
			//compteRepository.save(compteCourant);
			//compteRepository.save(compteEpargne);

		};
	}

}
