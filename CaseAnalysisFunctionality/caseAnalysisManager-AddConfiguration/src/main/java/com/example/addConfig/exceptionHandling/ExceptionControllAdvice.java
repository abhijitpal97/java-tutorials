package com.example.addConfig.exceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionControllAdvice extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(MissingDataException.class)
	public ResponseEntity<String> handleMissingData()
	{
		return new ResponseEntity<>("Input Data Missing" , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<String> handleNoData()
	{
		return new ResponseEntity<>("No Data Found for the process" , HttpStatus.NO_CONTENT);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return  new ResponseEntity<>("Wrong Method Type selected" , HttpStatus.METHOD_NOT_ALLOWED);
	}
	
}
