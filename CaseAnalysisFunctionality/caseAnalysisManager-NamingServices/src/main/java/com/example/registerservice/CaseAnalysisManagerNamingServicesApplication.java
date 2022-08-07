package com.example.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CaseAnalysisManagerNamingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAnalysisManagerNamingServicesApplication.class, args);
	}

}
