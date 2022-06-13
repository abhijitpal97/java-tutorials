package com.example.loginmodule.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loginmodule.bean.User;
import com.example.loginmodule.repository.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder password;
	
	public User createUser(User user) {
		user.setPassword(password.encode(user.getPassword()));
		return repo.save(user);		
	}
	
	public List<User> getUserbyName(String name) {
		return repo.findByUser(name);
	}


}
