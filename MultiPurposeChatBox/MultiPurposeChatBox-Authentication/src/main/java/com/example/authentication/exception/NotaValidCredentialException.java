package com.example.authentication.exception;

public class NotaValidCredentialException extends RuntimeException{
	
	String message = "";
	
	public NotaValidCredentialException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
