package com.example.searchmessage.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.searchmessage.bean.MessageSearchBean;
import com.example.searchmessage.bean.MessageSenderBean;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;

@Service
public class ElasticSearchService {
	
	@Autowired
	ElasticsearchClient client;

	public List<MessageSearchBean> searchMessage(String searchdata) throws ElasticsearchException, IOException {
		
		SearchResponse<MessageSenderBean> response = client.search(s -> s
				.index("messageindex") 
				.query(q -> q
						.wildcard(w -> w
								.field("storebean.message.keyword")
								.value(searchdata+"*"))),
				MessageSenderBean.class  
				);
		

		TotalHits total = response.hits().total();
		boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

		if (isExactResult) {
			System.out.println("There are " + total.value() + " results");
		} else {
			System.out.println("There are more than " + total.value() + " results");
		}
		
		List<MessageSearchBean> result = new ArrayList<>();
		
		List<Hit<MessageSenderBean>> hits = response.hits().hits();
		for (Hit<MessageSenderBean> hit: hits) {
			MessageSearchBean bean = new MessageSearchBean();
			MessageSenderBean local = hit.source();
			bean.setReceiverId(local.getMessagebean().getReceiverId());
			bean.setMessage(local.getStorebean().getMessage());
			
			result.add(bean);
		}
		
		return result;
				
	}

}
