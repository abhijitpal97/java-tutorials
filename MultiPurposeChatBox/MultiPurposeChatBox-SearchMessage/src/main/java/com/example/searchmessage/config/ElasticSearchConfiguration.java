package com.example.searchmessage.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticSearchConfiguration {
	
	
	@Bean
	public RestClient getRestClient()
	{
		RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.1.40" , 9200, "https"));
		
		HttpSecureConnectivity httpsucureConnection = new HttpSecureConnectivity();
		builder.setHttpClientConfigCallback(httpsucureConnection);
		
		RestClient restClient = builder.build();
		return restClient;
	}
	
	@Bean
	public ElasticsearchTransport getElasticsearchTransport()
	{
		return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
	}

	@Bean
	public ElasticsearchClient getElasticsearchClient()
	{
		ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
		
		return client;
	}

}
