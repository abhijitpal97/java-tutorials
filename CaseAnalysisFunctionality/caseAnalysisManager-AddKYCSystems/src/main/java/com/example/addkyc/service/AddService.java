package com.example.addkyc.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.example.addkyc.bean.CustomerBean;
import com.example.addkyc.repository.BeanRepository;
import com.example.addkyc.repository.ServiceRepository;

@Service
public class AddService implements ServiceRepository{
	
	@Autowired
	BeanRepository repo;
	
	
	@CacheEvict("kycServices")
	@CachePut("kycServices")
	@Override
	public CompletableFuture<CustomerBean> addCustomer(CustomerBean customerBean)
	{

		CustomerBean beansResult = repo.save(customerBean);

		return CompletableFuture.completedFuture(beansResult);
	}

}
