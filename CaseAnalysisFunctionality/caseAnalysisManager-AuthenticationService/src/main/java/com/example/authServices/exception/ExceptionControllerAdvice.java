package com.example.authServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.security.SignatureException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(NotaValidCredentialException.class)
	public ResponseEntity<String> handleInvalidCreds()
	{
		return new ResponseEntity<String>("Invalid Credentials" , HttpStatus.UNAUTHORIZED);
	}
	

}
