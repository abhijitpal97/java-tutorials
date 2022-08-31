package com.example.addConfig.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
import com.example.addConfig.kafkaService.Producer;
import com.example.addConfig.service.ConfigAddService;
import com.example.addConfig.service.ConfigFindService;

@RestController
@RequestMapping("/caseAnalysisService/v1/config")
public class BUConfigController {
	Logger log = LoggerFactory.getLogger(BUConfigController.class);


	@Autowired
	ConfigAddService services;

	@Autowired
	ConfigFindService findService;

	@Autowired
	Producer producer;

	@PostMapping("/saveBuConfigurations")
	public ResponseEntity<String> saveBuConfig(@RequestBody List<BUConfigurationBean> buNames) throws InterruptedException, ExecutionException
	{
		CompletableFuture<List<BUConfigurationBean>> future =services.addBuConfiguration(buNames);
		int count = future.get().size();
		if(count == buNames.size())
		{
			producer.producerData("Config", "Total "+count+" Bu addition Happen successfully. Result Set - "+buNames, "saveBukey");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/getBuConfigurations/{buName}")
	public List<BUConfigurationBean> getBuNames(@PathVariable String buName) throws InterruptedException, ExecutionException
	{

		List<BUConfigurationBean> future = CompletableFuture.supplyAsync(
				() -> {
					return findService.findConfigurationBybuName(buName);	
				}
				).get();
		if(! future.isEmpty())
			producer.producerData("Config", "Bu Search for Name "+buName+" done.", "auditkey");

		return future;
	}

	@GetMapping("/getBuConfigurationByRegion/{region}")
	public List<BUConfigurationBean> getBuNamesByRegion(@PathVariable String region) throws InterruptedException, ExecutionException
	{
		List<BUConfigurationBean> future =  CompletableFuture.supplyAsync(
				() -> {
					return findService.findConfigurationByburegion(region);	
				}
				).get();
		if(! future.isEmpty())
			producer.producerData("Config", "Bu Search based on Region "+region+" done.", "auditkey");
		return future;

	}


}
