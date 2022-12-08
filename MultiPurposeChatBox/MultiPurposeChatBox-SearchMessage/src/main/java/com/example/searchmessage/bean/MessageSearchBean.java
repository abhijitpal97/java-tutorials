package com.example.searchmessage.bean;


public class MessageSearchBean {

	private int receiverId;
	private String message;
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MessegeSearchBean [receiverId=" + receiverId + ", message=" + message + "]";
	}
	
	
}
