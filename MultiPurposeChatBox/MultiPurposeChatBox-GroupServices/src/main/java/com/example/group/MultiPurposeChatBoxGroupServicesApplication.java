package com.example.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MultiPurposeChatBoxGroupServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPurposeChatBoxGroupServicesApplication.class, args);
	}

}
