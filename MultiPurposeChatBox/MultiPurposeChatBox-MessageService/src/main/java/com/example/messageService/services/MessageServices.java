package com.example.messageService.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import com.example.messageService.bean.ConversationContactsBean;
import com.example.messageService.bean.MessageSenderBean;
import com.example.messageService.bean.MessageStoreBean;
import com.example.messageService.bean.MessengerBean;
import com.example.messageService.interfaces.MessageConversationJPARepo;
import com.example.messageService.interfaces.MessageServiceInterface;
import com.example.messageService.interfaces.MessageStoreJPARepo;
import com.example.messageService.interfaces.MessageStoreMongoRepo;

@Service
public class MessageServices implements MessageServiceInterface {
	Logger log = LoggerFactory.getLogger(MessageServices.class);
	MessageSenderBean result = new MessageSenderBean();
	@Autowired
	MessageStoreMongoRepo mongoRepo;
	
	@Autowired
	MessageStoreJPARepo jpaRepo;
	
	@Autowired
	FetchRecordService fetchServices;
	
	@Autowired
	MessageConversationJPARepo msgjpaRepo;
	
	@Override
	@Transactional
	public MessageSenderBean sendMessage(MessageSenderBean bean) {
		MessengerBean messenger = jpaRepo.save(bean.getMessagebean());
		if(messenger.getMessageId() > 0)
		{
			MessageStoreBean storeData = bean.getStorebean();
			storeData.setMessageId(messenger.getMessageId());
			MessageStoreBean store = mongoRepo.save(storeData);
			
			messenger.setRefId(String.valueOf(store.getId()));
			jpaRepo.save(messenger);
			
			result.setMessagebean(messenger);
			result.setStorebean(store);
			
			if(fetchServices.fetchConversationContact(messenger.getSenderId() , messenger.getReceiverId()).isEmpty()) storeConversationData(messenger.getSenderId() , messenger.getReceiverId());
		}
		return result;
	}

	private void storeConversationData(int senderId , int receiverId) {
		try
		{
			msgjpaRepo.save(new ConversationContactsBean(senderId, receiverId));
		}
		catch (Exception e) {
			log.error("Error in storeConversationData - " +e.getMessage());
		}
	}

}
