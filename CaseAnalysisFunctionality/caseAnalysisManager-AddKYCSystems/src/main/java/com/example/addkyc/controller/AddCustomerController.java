package com.example.addkyc.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.addkyc.KafkaService.Producer;
import com.example.addkyc.bean.CustomerBean;
import com.example.addkyc.service.AddService;
import com.example.addkyc.service.FindService;

@RestController
@RequestMapping("/caseAnalysisService/v1/kyc")
public class AddCustomerController {
	
	@Autowired
	AddService services;
	
	@Autowired
	Producer producer;
	
	@Autowired
	FindService findServices;
	@PostMapping("/addCustomerDetails")
	public CustomerBean addCustomer(@RequestBody CustomerBean customer) throws InterruptedException, ExecutionException
	{
		 CompletableFuture<CustomerBean> futureList = services.addCustomer(customer);
		 CustomerBean bean =  futureList.get();
		 
		 producer.producerData("AddKYCInformation", "Cutomer Information Stored { Name : "+bean.getCustomerName()+" , Gender: "+bean.getCustomerGender()+" }" , "addkycInformation");
		 
		 return bean;
	}
	
	@GetMapping("/findCustomerDetails/{id}")
	public CustomerBean getCustomerDetails(@PathVariable int id)
	{
		CustomerBean bean = findServices.getCustomerBean(id);
		producer.producerData("AddKYCInformation", "Cutomer Information Retrived for Id - "+id+" { + Name : "+bean.getCustomerName()+" , Gender: "+bean.getCustomerGender()+" }" , "auditkey");
		return bean;
	}

}
