package com.example.circuitBreaker.demoexamplecircuitbreaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.circuitBreaker.demoexamplecircuitbreaker.bean.EmployeeBean;
import com.example.circuitBreaker.demoexamplecircuitbreaker.services.CircuitServices;

@RestController
@RequestMapping("/circuitservices")
public class MainController {
	
	@Autowired
	private CircuitServices services;
	
	@GetMapping("/messages")
	public String getMessage()
	{
		return services.getMessage();
	}
	
	@GetMapping("/employees")
	public List<EmployeeBean> getEmployees()
	{
		return services.getEmployees();
	}
	
}
