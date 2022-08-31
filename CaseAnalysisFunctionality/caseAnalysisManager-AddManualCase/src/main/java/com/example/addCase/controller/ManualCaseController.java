package com.example.addCase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addCase.KafkaService.Producer;
import com.example.addCase.bean.CaseItemBean;
import com.example.addCase.service.ManualCaseService;

@RestController
@RequestMapping("/caseAnalysisService/v1/manual")
public class ManualCaseController {

	@Autowired
	ManualCaseService services;


	@Autowired
	Producer producer;

	@PostMapping("/addManualCase")
	public Map<String, List<CaseItemBean>> addManualCase(@RequestBody List<CaseItemBean> caseItembeans) throws Exception
	{
		Map<String, List<CaseItemBean>>  map = services.addManualCase(caseItembeans).get();
		List<String> bean = new ArrayList<>();
		map.forEach(

				(k,v) ->

				v.forEach( 
						(t) -> bean.add(t.getAlertid())
						)
				);

		producer.producerData("AddManualCase", "Manual Case Stored { AlertIds : "+bean+" }" , "addkycInformation");

		return map;
	}
	
	
	@GetMapping("/getCaseById/{id}")
	public CaseItemBean getCaseById(@PathVariable String id)
	{
		CaseItemBean bean = services.getCaseById(id);
		
		producer.producerData("GetManualCase", "Manual Case Retrived for Id - "+ bean.getAlertid(), "auditkey");
		
		return bean;
	}
}
