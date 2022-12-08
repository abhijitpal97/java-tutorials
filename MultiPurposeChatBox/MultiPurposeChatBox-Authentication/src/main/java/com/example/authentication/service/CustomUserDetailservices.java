package com.example.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.authentication.bean.UserBean;
import com.example.authentication.repository.JPARepository;

@Service
public class CustomUserDetailservices implements UserDetailsService{
	
	@Autowired
	JPARepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean user = repo.findByFirstNameAndIsActive(username,"Y");
		System.out.println("User Details in Validation - " + user);
		return new User(user.getFirstName(), user.getPassword(), new ArrayList<>());
	}

}
