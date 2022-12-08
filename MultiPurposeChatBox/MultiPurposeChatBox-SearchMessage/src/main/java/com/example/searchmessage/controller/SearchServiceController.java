package com.example.searchmessage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.searchmessage.bean.MessageSearchBean;
import com.example.searchmessage.services.SearchServices;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

@RestController
@RequestMapping("/searchMessageservice/v1")
public class SearchServiceController {
	
	@Autowired
	SearchServices services;
	
	@GetMapping("/searchMessage")
	public List<MessageSearchBean> searchMessage (@RequestBody String searchdata) throws ElasticsearchException, IOException
	{
		return services.searchMessage(searchdata);
	}

}
