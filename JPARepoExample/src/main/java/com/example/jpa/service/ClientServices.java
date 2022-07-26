package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.exception.MissingDataException;
import com.example.jpa.object.Client;
import com.example.jpa.repo.ClientRepo;

@Service
public class ClientServices {

	@Autowired
	ClientRepo repo;

	@Transactional
	public void addClient(Client client)
	{
		if(client.getName().isEmpty() || client.getLocation().isEmpty())
		{
			throw new MissingDataException("Data is missing!!");
		}
		repo.save(client);
	}
	
	
	public Optional<Client> getAllClientById(int Id)
	{
		Optional<Client> clients = repo.findById(Id);
		
		return clients;
	}

}
