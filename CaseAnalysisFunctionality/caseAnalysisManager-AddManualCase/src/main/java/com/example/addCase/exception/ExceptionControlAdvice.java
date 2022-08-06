package com.example.addCase.exception;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControlAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(GenericJDBCException.class)
	public ResponseEntity<String> hndlePersistingObject()
	{
		return new ResponseEntity<>("Not Able to persist the data. Issue with teh input parametes" , HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UnexpectedRollbackException.class)
	public ResponseEntity<String> hndlerollbackException()
	{
		return new ResponseEntity<>("Not Able to persist the data. Rollbacked." , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<String> handleResourceAccessException()
	{
		return new ResponseEntity<>("Not able to get the Requested Resource. Wait for sometime." , HttpStatus.BAD_REQUEST);
	}
	

}
