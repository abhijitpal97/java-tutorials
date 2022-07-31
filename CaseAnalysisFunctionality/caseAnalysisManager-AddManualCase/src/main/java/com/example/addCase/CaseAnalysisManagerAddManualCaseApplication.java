package com.example.addCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CaseAnalysisManagerAddManualCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAnalysisManagerAddManualCaseApplication.class, args);
	}

}
