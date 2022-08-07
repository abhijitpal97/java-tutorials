package com.example.addkyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addkyc.bean.CustomerBean;
import com.example.addkyc.repository.BeanRepository;
import com.example.addkyc.repository.FindServiceRepository;


@Service
public class FindService implements FindServiceRepository{

	@Autowired
	BeanRepository repo;
	
	@Override
	public CustomerBean getCustomerBean(int id) {
		
		return repo.findAllBycustId(id);
		
	}

}
