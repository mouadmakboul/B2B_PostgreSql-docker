package com.example.B2B;

import com.example.B2B.Entities.clientEntity;
import com.example.B2B.Repositories.clientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableTransactionManagement
@CrossOrigin(origins = "http://localhost:4200")
public class B2BApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2BApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(clientRepo cr) {
		return args -> {
			clientEntity client = clientEntity.builder()
					.id(1L)
					.nom_client("Nom du client")
					.adresse_client("Adresse du client")
					.build();

			cr.save(client);
		};
	}
}
