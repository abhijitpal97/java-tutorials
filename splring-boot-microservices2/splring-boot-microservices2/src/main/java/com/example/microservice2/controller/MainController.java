package com.example.microservice2.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.microservice2.bean.EmployeeBean;
import com.example.microservice2.service.DataService;

@RestController
@RequestMapping("/serviceemployees")
public class MainController {

	@Autowired
	DataService service;


	@GetMapping("/{id}/serviceemployee")
	public EmployeeBean getEmployee(@PathVariable int id)
	{
		return service.getEmployee(id);
	}



	@PostMapping("/update") 
	public ResponseEntity < Object > persistEmployee(@RequestBody EmployeeBean employee) 
	{ 
		EmployeeBean bean = service.updateDetails(employee); 
		if(bean !=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).build();  
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();

	}
	
	@GetMapping("/message")
	public String validatecall()
	{
		return "Inside Second Service call";
	}
	
	

}
