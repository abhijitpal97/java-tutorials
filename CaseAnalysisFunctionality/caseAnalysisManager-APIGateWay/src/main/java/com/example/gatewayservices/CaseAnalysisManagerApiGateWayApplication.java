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
				.route(r -> r.path("/caseAnalysisService/v1/config/**")
						.uri("http://localhost:9091"))
				.route(r -> r.path("//caseAnalysisService/v1/kyc/**")
						.uri("http://localhost:9093"))
				.route(r -> r.path("/caseAnalysisService/v1/manual/**")
						.uri("http://localhost:9096"))
				.route(r -> r.path("//caseAnalysisService/v1/notes/**")
						.uri("http://localhost:9097"))
				.route(r -> r.path("//caseAnalysisService/v1/attachments/**")
						.uri("http://localhost:9097"))
				.build();
	}
}
