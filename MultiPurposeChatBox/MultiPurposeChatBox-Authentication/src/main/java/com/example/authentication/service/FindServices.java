package com.example.authentication.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.bean.UserBean;
import com.example.authentication.repository.FindRepository;
import com.example.authentication.repository.JPARepository;


@Service
public class FindServices implements FindRepository{

	@Autowired
	JPARepository repo;
	
	@Override
	public Optional<UserBean> getUserDetails(Map<String, Object> userMap) {
		return repo.findById((int) userMap.get("userId")); 
	}


	
	
}
