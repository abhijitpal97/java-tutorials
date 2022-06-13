package com.example.loginmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginmodule.bean.User;
import com.example.loginmodule.services.UserServices;

@RestController
public class LoginUserCreation {
	
	@Autowired
	UserServices services;
	
	@PostMapping("/userCreation")
	public User createUser(@RequestBody User user)
	{
		return services.createUser(user);
	}

	@GetMapping("/getByUser/{user}")
	public List<User> getByUser(@PathVariable String user)
	{
		return services.getUserbyName(user);
	}
}
