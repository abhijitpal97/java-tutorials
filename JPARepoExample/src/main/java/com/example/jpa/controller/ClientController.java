package com.example.jpa.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


	//Calling same Method in Two Threads parallel results
	@GetMapping(value = "/findAllClients")
	public List<Client> getAllClients() throws InterruptedException, ExecutionException
	{
		CompletableFuture<List<Client>> c1 = services.getAllClient();
		CompletableFuture<List<Client>> c2 = services.getAllClient();
		
		CompletableFuture.allOf(c1,c2).join();
		
		return Stream.concat(c1.get().stream(), c2.get().stream())
                .collect(Collectors.toList());
	}
	
	
	//Calling same Method in Two Threads parallel results
	@GetMapping(value = "/findCompareCallAsyn")
	public Void runLambaComperatableFuture() throws InterruptedException, ExecutionException
	{
		CompletableFuture<Void> l1 = CompletableFuture.runAsync(
				() ->
				{
					CompletableFuture<List<Client>> c1 = services.getAllClient();
					CompletableFuture<List<Client>> c2 = services.getAllClient();
					try {
						c1.get().stream().forEach((t) ->
						System.out.println(t.getClientId())
						);
						
						c2.get().stream().forEach((t) ->
						System.out.println(t.getClientId())
						);
					} catch (InterruptedException e) {
						
					} catch (ExecutionException e) {
						
					}
				}
				);
		
		return l1.get();
	}
	
	@GetMapping(value = "/findCompareCallSupAsyn")
	public List<Client> runLambdaSupplierDemo() throws InterruptedException, ExecutionException
	{
	 Executor exec = Executors.newCachedThreadPool();
		return CompletableFuture.supplyAsync(
				() ->
				{return services.getAllClientData();},exec
				).get();
	}

	
	@GetMapping(value = "/deleteBuId/{Id}")
	public ResponseEntity<String> deleteById(@PathVariable int Id)
	{
		services.deleteById(Id);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
