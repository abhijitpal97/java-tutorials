package com.example.messageService.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageService.bean.MessageSenderBean;
import com.example.messageService.bean.MessageStoreBean;
import com.example.messageService.bean.MessengerBean;
import com.example.messageService.services.ElasticServices;
import com.example.messageService.services.MessageServices;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

@RestController
@RequestMapping("/messageservice/v1")
public class MessagingController {
	
	@Autowired
	MessageServices services;
	
	@Autowired
	ElasticServices elasticServices;
	
	@PostMapping("/sendMessage")
	public MessageSenderBean sendMessage(@RequestBody MessageSenderBean bean) throws ElasticsearchException, IOException
	{
		MessageSenderBean messageBean = services.sendMessage(bean);
		if(messageBean !=null)
			elasticServices.addorUpdateDocument(messageBean);
		
		return messageBean;
	}

}
