package com.example.jpa.exception;

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


	@ExceptionHandler(MissingDataException.class)
	public ResponseEntity<String> handleMissingData()
	{
		return new ResponseEntity<String>("Input Data Missing" , HttpStatus.BAD_REQUEST);
	}
	
	
	 @Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 return new ResponseEntity<Object>("Please Change your Method Type" , HttpStatus.METHOD_NOT_ALLOWED);
	 }

}
