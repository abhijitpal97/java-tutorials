package com.example.messageService.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "MESSAGESERVICE")
public class MessengerBean {

	@Id
	@SequenceGenerator(name = "msgSeq" , sequenceName = "MESSAGESEQUENCE" , initialValue = 1 , allocationSize = 1)
	@GeneratedValue(generator = "msgSeq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "MESSAGEID")
	private int messageId;
	@Column(name = "SENDERID")
	private int senderId;
	@Column(name = "RECEIVERID")
	private int receiverId;
	@Column(name = "ISREAD")
	private int isRead = 0;
	@Column(name = "REFERENCEID")
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
