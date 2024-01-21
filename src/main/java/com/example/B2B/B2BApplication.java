package com.example.B2B;

import com.example.B2B.Entities.ERole;
import com.example.B2B.Entities.Role;
import com.example.B2B.Entities.clientEntity;
import com.example.B2B.Repositories.RoleRepo;
import com.example.B2B.Repositories.clientRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(B2BApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(clientRepo cr) {
		return args -> {
			// Your existing client initialization code

			// Initialize roles
			Role roleAdmin = new Role(ERole.ROLE_ADMIN);
			Role roleUser = new Role(ERole.ROLE_USER);

			roleRepo.save(roleAdmin);
			roleRepo.save(roleUser);
		};
	}

}
