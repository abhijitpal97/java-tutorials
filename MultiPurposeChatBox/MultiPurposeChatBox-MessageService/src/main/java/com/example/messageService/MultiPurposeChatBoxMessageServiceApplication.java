package com.example.messageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MultiPurposeChatBoxMessageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPurposeChatBoxMessageServiceApplication.class, args);
	}

}
