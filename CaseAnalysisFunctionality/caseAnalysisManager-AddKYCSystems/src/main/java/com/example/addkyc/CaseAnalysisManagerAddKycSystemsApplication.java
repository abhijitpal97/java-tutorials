package com.example.addkyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CaseAnalysisManagerAddKycSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAnalysisManagerAddKycSystemsApplication.class, args);
	}

}
