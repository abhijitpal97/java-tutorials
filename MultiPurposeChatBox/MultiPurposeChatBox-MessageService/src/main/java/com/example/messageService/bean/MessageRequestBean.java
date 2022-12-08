package com.example.messageService.bean;

public class MessageRequestBean {
	
	private int senderId;
	private int receiverId;
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	@Override
	public String toString() {
		return "MessageRequestBean [senderId=" + senderId + ", receiverId=" + receiverId + "]";
	}
	
	

}
