package com.example.authservice.authentication.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.authservice.authentication.model.User;


@Repository
public interface UserRepo extends MongoRepository<User, String>{
	
	List<User> findByUser(String name);	

}
