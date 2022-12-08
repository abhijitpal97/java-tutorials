package com.example.authentication.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotaValidCredentialException.class)
	public ResponseEntity<String> handleInvalidCreds()
	{
		return new ResponseEntity<String>("Invalid Credentials" , HttpStatus.UNAUTHORIZED);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return  new ResponseEntity<>("Wrong Method Type selected" , HttpStatus.METHOD_NOT_ALLOWED);
	}

}
