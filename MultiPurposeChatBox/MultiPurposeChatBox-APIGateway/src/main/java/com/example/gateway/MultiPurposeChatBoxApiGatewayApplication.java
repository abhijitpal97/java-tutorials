package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiPurposeChatBoxApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPurposeChatBoxApiGatewayApplication.class, args);
	}
	
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/setPassword")
						.uri("http://localhost:2001"))
				.route(r -> r.path("/updateProfile")
						.uri("http://localhost:2001"))
				.route(r -> r.path("/deleteAccount")
						.uri("http://localhost:2001"))
				.route(r -> r.path("/actuator")
						.uri("http://localhost:2001"))
				.route(r -> r.path("/profilesetup/**")
						.uri("http://localhost:2002"))
				.route(r -> r.path("/messageservice/**")
						.uri("http://localhost:2003"))
				.route(r -> r.path("/searchMessageservice/**")
						.uri("http://localhost:2004"))
				.route(r -> r.path("/groupMessageService/**")
						.uri("http://localhost:2005"))
				.build();
	}

}
