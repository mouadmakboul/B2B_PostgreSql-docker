package com.example.B2B;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableTransactionManagement
@CrossOrigin(origins = "http://localhost:4200")

public class B2BApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2BApplication.class, args);
	}

}
