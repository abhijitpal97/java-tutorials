package com.example.addCase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.addCase.bean.BUConfigurationBean;
import com.example.addCase.bean.CaseItemBean;
import com.example.addCase.bean.ConfigurationBean;
import com.example.addCase.repository.ValidationInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ValidatorClass implements ValidationInterface{

	Logger logger = LoggerFactory.getLogger(ValidatorClass.class);

	@Bean
	@LoadBalanced
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
	
	
	@CircuitBreaker(name = "validateService" , fallbackMethod = "genericFallbackMethod")
	@Override
	public boolean isValidated(CaseItemBean items) throws ResourceAccessException{

		ResponseEntity<List<ConfigurationBean>> result =
				getTemplate().exchange("http://localhost:9091/caseAnalysisService/getConfigurationByRegion/NAM",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<ConfigurationBean>>() {
				});
		List<ConfigurationBean> configuration = result.getBody();

		List<String> escMarker = new ArrayList<>();
		List<String> focusType = new ArrayList<>();

		for(ConfigurationBean bean : configuration)
		{
			if(bean.getConfigkey().equals("Escalation Marker"))
				escMarker.add(bean.getConfigvalues());
			else if(bean.getConfigkey().equals("FocusType"))
				focusType.add(bean.getConfigvalues());
			else
				logger.info("No such validation required for the key -  "+bean.getConfigkey());			
		}

		ResponseEntity<List<BUConfigurationBean>> buResult =
				getTemplate().exchange("http://localhost:9091/caseAnalysisService/getBuConfigurationByRegion/NAM",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<BUConfigurationBean>>() {
				});

		List<BUConfigurationBean> buConfiguration = buResult.getBody();
		List<String> buIds = buConfiguration.stream().map((t) -> t.getBuName()).collect(Collectors.toList());
		System.out.println(buIds);
		if(focusType.contains(items.getFocustype()) && escMarker.contains(items.getEscalationmarker()) 
				&& buIds.contains(items.getBusinessunit()))
			return true;
		else
			return false;		
	}
	
	public boolean genericFallbackMethod(Exception e) throws ResourceAccessException{
		return false;
	}
}
