package com.example.authservice.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.authservice.authentication.repository")
public class DemoAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthServiceApplication.class, args);
	}

}
