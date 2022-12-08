package com.example.messageService.interfaces;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.messageService.bean.MessageRequestBean;
import com.example.messageService.bean.MessageSenderBean;

public interface MessageServiceFetchInterface {
	
	public List<MessageSenderBean> fetchMessage(MessageRequestBean request);
	List<Integer> fetchConversationContact(int senderId, int receiverId);
	List<Integer> fetchConversationList(int senderId);

}
