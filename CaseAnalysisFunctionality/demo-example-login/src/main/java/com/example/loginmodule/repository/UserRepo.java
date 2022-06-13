package com.example.loginmodule.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.loginmodule.bean.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{

	List<User> findByUser(String name);	
}
