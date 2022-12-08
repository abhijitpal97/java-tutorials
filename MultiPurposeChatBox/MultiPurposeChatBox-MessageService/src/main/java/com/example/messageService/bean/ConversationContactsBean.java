package com.example.messageService.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositeKey.class)
@Table(name = "CONVERSATIONCONTACTSERVICE")
public class ConversationContactsBean {
	
	@Id
	@Column(name = "SENDERID")
	private int senderId;
	@Id
	@Column(name = "RECEIVERID")
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
		return "ConversationContactsBean [senderId=" + senderId + ", receiverId=" + receiverId + "]";
	}
	
	public ConversationContactsBean() {
		// TODO Auto-generated constructor stub
	}
	public ConversationContactsBean(int senderId, int receiverId) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
	}
	
	
	
}
