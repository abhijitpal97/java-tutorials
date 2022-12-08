package com.example.messageService.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.messageService.bean.MessageRequestBean;
import com.example.messageService.bean.MessageSenderBean;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQueryField;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;

@Service
public class ElasticServices {

	@Autowired
	ElasticsearchClient client;


	public String addorUpdateDocument(MessageSenderBean messageBean) throws ElasticsearchException, IOException {

		IndexResponse response = client.index(
				i -> i.index("messageindex").id(String.valueOf(messageBean.getMessagebean().getMessageId()))
				.document(messageBean)
				); 
		return response.result().name();
	}
	
	public List<MessageSenderBean> retriveDocumet(MessageRequestBean request)
	{
		List<MessageSenderBean> result = new ArrayList<>();
		List<FieldValue> sender = List.of(request.getSenderId() , request.getReceiverId()).stream().map((FieldValue::of)).collect(Collectors.toList());
		List<FieldValue> receiver =  List.of(request.getSenderId() , request.getReceiverId()).stream().map((FieldValue::of)).collect(Collectors.toList());

		TermsQueryField senderTerms = new TermsQueryField.Builder()
				.value(sender)
				.build();

		TermsQueryField receiverTerms = new TermsQueryField.Builder()
				.value(receiver)
				.build();

		Query querySender = new Query.Builder().terms(t1 ->  
		t1.field("messagebean.senderId").terms(senderTerms)
		).build();
		
		Query queryReceiver = new Query.Builder().terms(t1 ->  
		t1.field("messagebean.receiverId").terms(receiverTerms)
		).build();
		
		List<Query> list = List.of(querySender , queryReceiver);
		
		try
		{
			SearchResponse<MessageSenderBean> response = client.search(s -> s
					.index("messageindex") 
					.query( t -> t.
							bool(b -> b.
									must( m -> m.
											bool(b1 -> b1.
													must(list))))
							),
					MessageSenderBean.class  
					);

			TotalHits total = response.hits().total();
			boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

			if (isExactResult) {
				System.out.println("There are " + total.value() + " results");
			} else {
				System.out.println("There are more than " + total.value() + " results");
			}


			List<Hit<MessageSenderBean>> hits = response.hits().hits();
			for (Hit<MessageSenderBean> hit: hits) {
				result.add(hit.source());				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
