package com.example.searchmessage.config;

import java.io.File;

import javax.net.ssl.SSLContext;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;

public class HttpSecureConnectivity implements HttpClientConfigCallback{

	@Override
	public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
		
		try {
			final CredentialsProvider provider = new BasicCredentialsProvider();
			UsernamePasswordCredentials upId = new UsernamePasswordCredentials("elastic" , "jPTSGW5lk0UR-WO48pdh");
			
			provider.setCredentials(AuthScope.ANY, upId);
			httpClientBuilder.setDefaultCredentialsProvider(provider);
			
			String trustStorePath = "C:\\Users\\abhijit\\ElasticStack\\elasticsearch-node1\\config\\certs\\truststore.p12";
			
			File trustStoreFile = new File(trustStorePath);
			
			SSLContextBuilder sslContext = SSLContexts.custom().loadTrustMaterial(trustStoreFile, "password".toCharArray());
			
			 SSLContext context = sslContext.build();
			 
			 httpClientBuilder.setSSLContext(context);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return httpClientBuilder;
		
	}

}
