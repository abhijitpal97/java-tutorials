package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class JpaRepoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepoExampleApplication.class, args);
	}

}
