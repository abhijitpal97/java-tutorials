package com.example.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.utility.JWTUtility;

@RestController
public class ValidateTokenController {
	
	@Autowired
	JWTUtility jutil;
	
	
	@GetMapping("/validateToken")
	public boolean generateToken(@RequestHeader("Authorization")  String token)
	{
		if(token !=null && token.startsWith("Bearer")) {
			token=token.substring(7);
		}
		return jutil.validateToken(token);
	}

}
