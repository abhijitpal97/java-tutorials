package com.example.authServices.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.authServices.bean.UserBean;
import com.example.authServices.repository.UserRepository;


@Service
public class CustomUserDetailservices implements UserDetailsService{

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserBean user = repository.findByname(name);
		System.out.println(user.getName() + " - " + user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getName() , user.getPassword() , new ArrayList<>());
	}

}
