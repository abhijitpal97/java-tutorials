package com.example.searchmessage.bean;

public class MessengerBean {

	private int messageId;
	private int senderId;
	private int receiverId;
	private int isRead = 0;
	private String refId;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
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
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	@Override
	public String toString() {
		return "MessengerBean [messageId=" + messageId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", isRead=" + isRead + ", refId=" + refId + "]";
	}
	
		
}
