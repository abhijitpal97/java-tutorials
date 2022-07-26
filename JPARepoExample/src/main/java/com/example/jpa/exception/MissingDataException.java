package com.example.jpa.exception;

public class MissingDataException extends RuntimeException {

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public MissingDataException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}



}
