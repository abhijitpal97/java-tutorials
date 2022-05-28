package com.example.microservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice1.bean.EmployeeBean;
import com.example.microservice1.service.DataService;

@RestController
public class MainController {

	@Autowired
	DataService service;
	
	@GetMapping("/employees/{id}/employee")
	public EmployeeBean getId(@PathVariable int id)
	{
		return service.getEmployee(id);
	}
}
