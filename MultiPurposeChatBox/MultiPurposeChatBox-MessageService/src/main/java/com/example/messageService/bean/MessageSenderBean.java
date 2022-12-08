package com.example.messageService.bean;

public class MessageSenderBean {
	
	private MessengerBean messagebean;
	private MessageStoreBean storebean;
	public MessengerBean getMessagebean() {
		return messagebean;
	}
	public void setMessagebean(MessengerBean messagebean) {
		this.messagebean = messagebean;
	}
	public MessageStoreBean getStorebean() {
		return storebean;
	}
	public void setStorebean(MessageStoreBean storebean) {
		this.storebean = storebean;
	}
	@Override
	public String toString() {
		return "MessageSenderBean [messagebean=" + messagebean + ", storebean=" + storebean + "]";
	}
	
	

}
