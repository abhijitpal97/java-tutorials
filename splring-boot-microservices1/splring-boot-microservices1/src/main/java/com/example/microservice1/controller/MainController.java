package com.example.microservice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice1.bean.EmployeeBean;
import com.example.microservice1.service.DataService;

@RestController
@RequestMapping("/employees")
public class MainController {

	@Autowired
	DataService service;
	
	@GetMapping("/{id}/employee")
	public EmployeeBean getId(@PathVariable int id)
	{
		return service.getEmployee(id);
	}
	
	@GetMapping("/message")
	public String validatecall()
	{
		return "Inside First Service call";
	}
	
	@GetMapping("/employees")
	public List<EmployeeBean> getEmployees()
	{
		System.out.println("Inside Main Controller 1");
		return service.getEmployees();
	}
}
