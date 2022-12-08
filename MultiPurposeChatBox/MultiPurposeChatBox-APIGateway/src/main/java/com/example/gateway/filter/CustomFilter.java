package com.example.gateway.filter;

import java.util.Optional;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter implements GlobalFilter , Ordered{

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		boolean isAuthorized=false;
		if(! exchange.getRequest().getHeaders().containsKey("Authorization"))
		{
			throw new RuntimeException("No Authorization Key Present !");
		}
		
		else
		{
			try {
				isAuthorized = isAuthorize(exchange.getRequest().getHeaders().get("Authorization").get(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(!isAuthorized){
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you can't consume this service , Please validate your User Details!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you can't consume this service , Please validate your User Details!!");
		}

		return chain.filter(exchange);
	}

	private boolean isAuthorize(String token) {


		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);


		ResponseEntity<Boolean> response =  getTemplate().exchange("http://localhost:2001/validateToken", HttpMethod.GET, requestEntity, Boolean.class);
		boolean result = Optional.ofNullable(response.getBody()).orElse(false);
		System.out.println(result);
		return result;
	
	}
	
	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}

}
