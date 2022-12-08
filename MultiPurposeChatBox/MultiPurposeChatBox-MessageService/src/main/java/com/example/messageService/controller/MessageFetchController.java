package com.example.messageService.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageService.bean.MessageRequestBean;
import com.example.messageService.bean.MessageSenderBean;
import com.example.messageService.services.FetchRecordService;

@RestController
@RequestMapping("/messageservice/v1")
public class MessageFetchController {

	@Autowired
	FetchRecordService services;
	
	@GetMapping("/fetchMessageforReceiver")
	public List<MessageSenderBean> fetchMessage(@RequestBody MessageRequestBean request)
	{
		return services.fetchMessage(request);
	}
	
	@GetMapping("/fetchConversationContact")
	public List<Integer> fetchConversationContact(@RequestBody int senderId)
	{
		return services.fetchConversationList(senderId);
	}
}
