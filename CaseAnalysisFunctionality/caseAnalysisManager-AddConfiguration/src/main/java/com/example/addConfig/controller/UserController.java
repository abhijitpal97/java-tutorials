package com.example.addConfig.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addConfig.bean.UserBean;
import com.example.addConfig.kafkaService.Producer;
import com.example.addConfig.service.ConfigAddService;
import com.example.addConfig.service.ConfigFindService;

@RestController
@RequestMapping("/caseAnalysisService")
public class UserController {

	@Autowired
	ConfigAddService services;

	@Autowired
	ConfigFindService findService;

	@Autowired
	Producer producer;


	@PostMapping("/addUserDetails")
	public ResponseEntity<String> saveBuConfig(@RequestBody List<UserBean> users) throws InterruptedException, ExecutionException
	{
		CompletableFuture<List<UserBean>> future =services.addUsers(users);
		if(future.get().size() == users.size())
		{
			producer.ProducerData("Config", "Users added successfully. Total Count - "+users.size(), "saveuserkey");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/getUsersByName/{name}")
	public List<UserBean> getUsersByNames(@PathVariable String name) throws InterruptedException, ExecutionException
	{
		List<UserBean> future =  CompletableFuture.supplyAsync(
				() -> {
					return findService.findUserByname(name);	
				}
				).get();

		if(! future.isEmpty())
			producer.ProducerData("Config", "User Search based on Name "+name+" done.", "auditkey");
		return future;

	}

}
