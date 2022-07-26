package com.example.jpa.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.object.Client;
import com.example.jpa.service.ClientServices;

@RestController
@RequestMapping("/clientservice")
public class ClientController {
	
	@Autowired
	ClientServices services;
	
	@PostMapping(value = "/add")
	public void addClient(@RequestBody Client client)
	{
		services.addClient(client);					
	}
	
	
	@GetMapping(value = "/findbyclientId/{Id}")
	public Optional<Client> getClients(@PathVariable int Id)
	{
		return services.getAllClientById(Id);
	}

}
