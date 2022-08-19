package com.example.authServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authServices.bean.AuthRequest;
import com.example.authServices.exception.NotaValidCredentialException;
import com.example.authServices.utility.JWTUtility;



@RestController
public class TokenCreateController {

	@Autowired
	JWTUtility jutil;

	@Autowired
	AuthenticationManager authManager;


	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest auth) throws Exception
	{
		
		try
		{

			authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));
			return jutil.generateToken(auth.getUserName());
		}
		catch (NotaValidCredentialException e) {
			throw new NotaValidCredentialException("Invalid Credentials");
		}

	}
	
	
	@GetMapping("/validateToken")
	public boolean generateToken(@RequestHeader("Authorization")  String token)
	{
		if(token !=null && token.startsWith("Bearer")) {
			token=token.substring(7);
		}
		return jutil.validateToken(token);
	}

}
