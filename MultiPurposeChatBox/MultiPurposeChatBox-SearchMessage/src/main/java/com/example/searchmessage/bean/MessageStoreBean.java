package com.example.searchmessage.bean;

public class MessageStoreBean {
	
	private String id;
	private int messageId;
	private String message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MessageStoreBean [id=" + id + ", messageId=" + messageId + ", message=" + message + "]";
	}
	
	
	

}
