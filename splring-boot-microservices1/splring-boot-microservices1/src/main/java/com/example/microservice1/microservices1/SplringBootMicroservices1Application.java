package com.example.microservice1.microservices1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.microservice1")
public class SplringBootMicroservices1Application {

	public static void main(String[] args) {
		SpringApplication.run(SplringBootMicroservices1Application.class, args);
	}

}
