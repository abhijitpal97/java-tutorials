package com.example.searchmessage.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.searchmessage.bean.MessageSearchBean;
import com.example.searchmessage.interfaces.SearchDataInterface;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

@Service
public class SearchServices  implements SearchDataInterface{

	@Autowired
	ElasticSearchService service;
	
	@Override
	public List<MessageSearchBean> searchMessage(String searchdata) throws ElasticsearchException, IOException {
		return service.searchMessage(searchdata);
	}

}
