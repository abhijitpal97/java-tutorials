package com.example.addCase.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.addCase.bean.CaseItemBean;
import com.example.addCase.bean.ConfigurationBean;
import com.example.addCase.repository.ValidationInterface;

@Component
public class ValidatorClass implements ValidationInterface{

	Logger logger = LoggerFactory.getLogger(ValidatorClass.class);

	@Override
	public boolean isValidated(CaseItemBean items) {

		ResponseEntity<List<ConfigurationBean>> result =
				new RestTemplate().exchange("http://localhost:9091/caseAnalysisService/getConfigurationByRegion/NAM",
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

		if(focusType.contains(items.getFocustype()) && escMarker.contains(items.getEscalationmarker()))
			return true;
		else
			return false;

	}



}
