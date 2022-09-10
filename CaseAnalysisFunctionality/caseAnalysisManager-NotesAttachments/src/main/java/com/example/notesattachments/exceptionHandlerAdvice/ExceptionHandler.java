package com.example.notesattachments.exceptionHandlerAdvice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<String> handleNoData()
	{
		return new ResponseEntity<>("Maximum File Size Limit Exceeds" , HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<>("Wrong Method Type selected" , HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	

}
