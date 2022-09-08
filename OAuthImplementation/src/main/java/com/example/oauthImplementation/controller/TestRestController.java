package com.example.oauthImplementation.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController{

	@GetMapping("/test1")
	public String getTest()
	{
		return "Test1 Success by ";
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal principal)
	{
		return principal;
		
	}

}
