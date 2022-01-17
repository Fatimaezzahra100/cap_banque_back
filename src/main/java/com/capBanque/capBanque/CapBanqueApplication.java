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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
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

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
