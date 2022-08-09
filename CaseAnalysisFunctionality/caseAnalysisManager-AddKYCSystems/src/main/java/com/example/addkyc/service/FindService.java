package com.example.addkyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.addkyc.bean.CustomerBean;
import com.example.addkyc.repository.BeanRepository;
import com.example.addkyc.repository.FindServiceRepository;


@Service
public class FindService implements FindServiceRepository{

	@Autowired
	BeanRepository repo;
	
	@Override
	@Cacheable("kycServices")
	public CustomerBean getCustomerBean(int id) {
		System.out.println("Inside DB Hit Method");
		return repo.findAllBycustId(id);
		
	}

}
