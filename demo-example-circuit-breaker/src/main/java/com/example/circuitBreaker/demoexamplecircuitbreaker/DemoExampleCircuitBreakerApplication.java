package com.example.circuitBreaker.demoexamplecircuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCircuitBreaker
public class DemoExampleCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoExampleCircuitBreakerApplication.class, args);
	}

}
