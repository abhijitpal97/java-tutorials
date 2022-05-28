package com.example.microservice2.microservices2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.microservice2")
public class SplringBootMicroservices2Application {

	public static void main(String[] args) {
		SpringApplication.run(SplringBootMicroservices2Application.class, args);
	}

}
