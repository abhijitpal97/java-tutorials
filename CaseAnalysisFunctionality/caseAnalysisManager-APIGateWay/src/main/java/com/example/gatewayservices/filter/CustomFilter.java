package com.example.gatewayservices.filter;

import java.util.Optional;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import com.example.gatewayservices.bean.AuthRequest;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter implements GlobalFilter,Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		try {
			if(!isAuthorize("Abhijit", "password1")){
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you can't consume this service , Please validate your User Details!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you can't consume this service , Please validate your User Details!!");
		}

		return chain.filter(exchange);
	}

	private boolean isAuthorize(String username , String password) throws Exception{
		AuthRequest authRequest = new AuthRequest(username, password);
		String response = Optional.ofNullable(
				getTemplate().postForObject("http://localhost:9095/authenticate", authRequest, String.class)).orElse("");


		System.out.println(response);
		boolean flag = response.equalsIgnoreCase("") || response.equalsIgnoreCase("Invalid Credentials");
		return flag==false?true:false;
	}

	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return Ordered.LOWEST_PRECEDENCE;
	}
}
