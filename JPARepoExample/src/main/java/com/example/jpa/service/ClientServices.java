package com.example.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.jpa.exception.MissingDataException;
import com.example.jpa.object.Client;
import com.example.jpa.repo.ClientRepo;

@Service
public class ClientServices {

	Logger log = LoggerFactory.getLogger(ClientServices.class);
	
	@Autowired
	ClientRepo repo;

	@Transactional
	@CacheEvict(value="client",  allEntries = true) 
	@CachePut(value = "client")
	public void addClient(Client client)
	{
		if(client.getName().isEmpty() || client.getLocation().isEmpty())
		{
			throw new MissingDataException("Data is missing!!");
		}
		repo.save(client);
	}


	@Cacheable("client")
	public Optional<Client> getAllClientById(int Id)
	{
		Optional<Client> clients = repo.findById(Id);

		return clients;
	}

	
	@Async
	public CompletableFuture<List<Client>> getAllClient()
	{
		log.info("Current Log - " + Thread.currentThread().getName());
		List<Client> clients = repo.findAll();
		return CompletableFuture.completedFuture(clients);
	}
	
	
	public List<Client> getAllClientData()
	{
		log.info("Current Log - " + Thread.currentThread().getName());
		List<Client> clients = repo.findAll();
		System.out.println(clients);
		return clients;
	}


	@CacheEvict(cacheNames = "client" , allEntries = true)
	public void deleteById(int id) {
		
		repo.deleteById(id);
		
	}

}
