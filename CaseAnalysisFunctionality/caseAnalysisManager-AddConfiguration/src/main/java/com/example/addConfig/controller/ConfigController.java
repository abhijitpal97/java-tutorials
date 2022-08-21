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
import com.example.addConfig.kafkaService.Producer;
import com.example.addConfig.service.ConfigAddService;
import com.example.addConfig.service.ConfigFindService;

@RestController
@RequestMapping("/caseAnalysisService")
public class ConfigController {
	Logger log = LoggerFactory.getLogger(ConfigController.class);


	@Autowired
	ConfigAddService services;

	@Autowired
	ConfigFindService findService;

	@Autowired
	Producer producer;
	
	@PostMapping("/saveConfigurations")
	public ResponseEntity<Object> saveConfig(@RequestBody List<ConfigurationBean> config) throws InterruptedException, ExecutionException
	{
		CompletableFuture<List<ConfigurationBean>> result = services.addConfiguration(config);

		if(result.get().size() == config.size())
		{
			producer.ProducerData("Config", "Added Configurations - "+config, "saveconfigkey");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
			
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}


	@GetMapping("/getConfiguration/{key}")
	public List<ConfigurationBean> getConfigurationByKey(@PathVariable String key) throws InterruptedException, ExecutionException
	{
		List<ConfigurationBean> future =  CompletableFuture.supplyAsync(
				() -> {return findService.findConfigurationByConfigKey(key);}
				).get();
		
		if(! future.isEmpty())
			producer.ProducerData("Config", "Configuration Search based on Key "+key+" done.", "auditkey");
		return future;

	}

	@GetMapping("/getConfigurationByRegion/{region}")
	public List<ConfigurationBean> getConfigurationByRegion(@PathVariable String region) throws InterruptedException, ExecutionException
	{
		List<ConfigurationBean> future =  CompletableFuture.supplyAsync(
				() -> {
					return findService.findConfigurationByregion(region);	
				}
				).get();
		
		if(! future.isEmpty())
			producer.ProducerData("Config", "Configuration Search based on Region "+region+" done.", "auditkey");
		return future;

	}


}
