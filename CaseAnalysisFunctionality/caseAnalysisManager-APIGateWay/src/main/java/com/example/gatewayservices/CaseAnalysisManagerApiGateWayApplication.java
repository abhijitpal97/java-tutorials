package com.example.gatewayservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CaseAnalysisManagerApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAnalysisManagerApiGateWayApplication.class, args);
	}


	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/caseAnalysisService/**")
						.uri("http://localhost:9091"))
				.route(r -> r.path("/caseAnalysisService/**")
						.uri("http://localhost:9092"))
				.route(r -> r.path("/caseAnalysisService/**")
						.uri("http://localhost:9093"))
				.build();
	}
}
