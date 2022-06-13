package com.example.authservice.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authservice.authentication.model.User;
import com.example.authservice.authentication.repository.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo userRepo;
	
	public List<User> getUserbyName(String name) {
		return userRepo.findByUser(name);
	}

}
