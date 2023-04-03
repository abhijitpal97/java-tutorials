package com.example.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger/api/v1")
public class MainController {

	@GetMapping("/getContact/{id}")
	public String getContact(@PathVariable int id)
	{
		return "Result for Id - "+id;
	}

	@GetMapping("/getContacts")
	public List<String> getAllContact()
	{
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++)
		{
			list.add("Result for Id - "+i);
		}

		return list;

	}
	
	@PostMapping("/addContacts")
	public String addContacts(@RequestBody String str)
	{
		return "Contacts added - "+str;
	}

}
