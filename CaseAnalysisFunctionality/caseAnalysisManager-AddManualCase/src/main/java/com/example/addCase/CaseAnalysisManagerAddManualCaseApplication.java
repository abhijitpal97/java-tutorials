package com.example.addCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class CaseAnalysisManagerAddManualCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAnalysisManagerAddManualCaseApplication.class, args);
	}

}
