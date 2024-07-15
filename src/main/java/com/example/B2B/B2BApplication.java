package com.example.B2B;

import com.example.B2B.Entities.ERole;
import com.example.B2B.Entities.Role;
import com.example.B2B.Entities.clientEntity;
import com.example.B2B.Entities.entrepriseEntity;
import com.example.B2B.Repositories.RoleRepo;
import com.example.B2B.Repositories.entrepriseRepo;
import com.example.B2B.Repositories.clientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@CrossOrigin(origins = "http://localhost:4200")
public class B2BApplication {

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private entrepriseRepo entrepriseRepo;

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
			entrepriseEntity entreprise = new entrepriseEntity();
			entreprise.setNom("capgemini");
			entreprise.setAdresse("casanearshore");
			entreprise.setTel("0107472");
			entreprise.setEmail("capgemini@gmail.com");
			entrepriseEntity entreprise1 = new entrepriseEntity();
			entreprise1.setNom("IBM");
			entreprise1.setAdresse("casanearshore");
			entreprise1.setTel("132434472");
			entreprise1.setEmail("IBM@gmail.com");
			entrepriseEntity entreprise2 = new entrepriseEntity();
			entreprise2.setNom("MAROCTELECOM");
			entreprise2.setAdresse("casanearshore");
			entreprise2.setTel("13423472");
			entreprise2.setEmail("MAROCTELECOM@gmail.com");
			entrepriseEntity entreprise3 = new entrepriseEntity();
			entreprise3.setNom("Orange");
			entreprise3.setAdresse("casanearshore");
			entreprise3.setTel("1332372");
			entreprise3.setEmail("Orange@gmail.com");
			entrepriseEntity entreprise4 = new entrepriseEntity();
			entreprise4.setNom("Inetum");
			entreprise4.setAdresse("casanearshore");
			entreprise4.setTel("1327472");
			entreprise4.setEmail("Orange@gmail.com");
			entrepriseEntity entreprise5 = new entrepriseEntity();
			entreprise5.setNom("capgeminiEnginnering");
			entreprise5.setAdresse("casanearshore");
			entreprise5.setTel("143347472");
			entreprise5.setEmail("capgeminiEnginnering@gmail.com");
			entrepriseEntity entreprise6 = new entrepriseEntity();
			entreprise6.setNom("ATOS");
			entreprise6.setAdresse("casanearshore");
			entreprise6.setTel("132102972");
			entreprise6.setEmail("ATOS@gmail.com");
			entrepriseEntity entreprise7 = new entrepriseEntity();
			entreprise7.setNom("EMSI");
			entreprise7.setAdresse("casanearshore");
			entreprise7.setTel("1373472");
			entreprise7.setEmail("EMSI@gmail.com");

//
			List<entrepriseEntity> entreprises = Arrays.asList(entreprise, entreprise1, entreprise2, entreprise3, entreprise4, entreprise5, entreprise6, entreprise7);

			entrepriseRepo.saveAll(entreprises);

		};
	}

}
