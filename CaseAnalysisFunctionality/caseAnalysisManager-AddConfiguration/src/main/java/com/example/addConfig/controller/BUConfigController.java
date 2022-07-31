package com.example.addConfig.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addConfig.bean.BUConfigurationBean;
import com.example.addConfig.bean.ConfigurationBean;
import com.example.addConfig.service.ConfigAddService;
import com.example.addConfig.service.ConfigFindService;

@RestController
@RequestMapping("/caseAnalysisService")
public class BUConfigController {
	Logger log = LoggerFactory.getLogger(BUConfigController.class);


	@Autowired
	ConfigAddService services;

	@Autowired
	ConfigFindService findService;

	
	@PostMapping("/saveBuConfigurations")
	public ResponseEntity<String> saveBuConfig(@RequestBody List<BUConfigurationBean> buNames) throws InterruptedException, ExecutionException
	{
		CompletableFuture<List<BUConfigurationBean>> future =services.addBuConfiguration(buNames);
		if(future.get().size() == buNames.size())
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/getBuConfigurations/{buName}")
	public List<BUConfigurationBean> getBuNames(@PathVariable String buName) throws InterruptedException, ExecutionException
	{
		return CompletableFuture.supplyAsync(
				() -> {
				return findService.findConfigurationBybuName(buName);	
				}
				).get();
				
	}
	
	@GetMapping("/getBuConfigurationByRegion/{region}")
	public List<BUConfigurationBean> getBuNamesByRegion(@PathVariable String region) throws InterruptedException, ExecutionException
	{
		return CompletableFuture.supplyAsync(
				() -> {
				return findService.findConfigurationByburegion(region);	
				}
				).get();
				
	}


}
