package com.example.messageService.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.messageService.bean.ConversationContactsBean;
import com.example.messageService.bean.MessageRequestBean;
import com.example.messageService.bean.MessageSenderBean;
import com.example.messageService.bean.MessageStoreBean;
import com.example.messageService.interfaces.MessageConversationJPARepo;
import com.example.messageService.interfaces.MessageServiceFetchInterface;
import com.example.messageService.interfaces.MessageStoreJPARepo;
import com.example.messageService.interfaces.MessageStoreMongoRepo;

@Service
public class FetchRecordService implements MessageServiceFetchInterface{

	@Autowired
	MessageStoreJPARepo jpaRepo;
	
	@Autowired
	MessageStoreMongoRepo mongoRepo;
	
	@Autowired
	ElasticServices elasticServices;
	
	@Autowired
	MessageConversationJPARepo msgjpaRepo;
	@Override
	public List<MessageSenderBean> fetchMessage(MessageRequestBean request) {
		/*
		 * List<Integer> result =
		 * jpaRepo.findMessengerBeanBysenderIdAndreceiverId(request.getSenderId() ,
		 * request.getReceiverId()); CopyOnWriteArrayList<String> messages = new
		 * CopyOnWriteArrayList<>(); System.out.println(result); List<MessageStoreBean>
		 * store = mongoRepo.findAllBymessageIdIn(result); if(!store.isEmpty()) {
		 * store.forEach( (t) -> messages.add(t.getMessage()) );
		 * 
		 * return messages; } messages.add("No Sent Messages"); return messages;
		 * 
		 */
		return elasticServices.retriveDocumet(request);	
	
	}

	@Override
	public List<Integer> fetchConversationContact(int senderId , int receiverId) {
		List<Integer> contactsBean = msgjpaRepo.findBysenderId(senderId , receiverId);
		
		if(! contactsBean.isEmpty())
		{
			return contactsBean;
		}
		else return new ArrayList<>();
		
	}

	@Override
	public List<Integer> fetchConversationList(int senderId) {
		List<Integer> contactsBean = msgjpaRepo.findBysenderId(senderId);
		
		if(! contactsBean.isEmpty())
		{
			return contactsBean;
		}
		else return new ArrayList<>();
	}
	
	

}
