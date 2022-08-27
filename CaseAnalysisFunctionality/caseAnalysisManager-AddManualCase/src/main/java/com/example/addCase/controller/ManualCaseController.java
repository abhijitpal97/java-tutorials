package com.example.addCase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addCase.bean.CaseItemBean;
import com.example.addCase.service.ManualCaseService;
import com.example.addkyc.KafkaService.Producer;

@RestController
@RequestMapping("/caseAnalysisService/v1")
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
}
