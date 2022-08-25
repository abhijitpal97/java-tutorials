package com.example.addCase.controller;

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

@RestController
@RequestMapping("/caseAnalysisService/v1")
public class ManualCaseController {

	@Autowired
	ManualCaseService services;
	
	@PostMapping("/addManualCase")
	public Map<String, List<CaseItemBean>> addManualCase(@RequestBody List<CaseItemBean> caseItembeans) throws Exception
	{
		CompletableFuture<Map<String, List<CaseItemBean>>>  map = services.addManualCase(caseItembeans);
		
		return map.get();
	}
}
