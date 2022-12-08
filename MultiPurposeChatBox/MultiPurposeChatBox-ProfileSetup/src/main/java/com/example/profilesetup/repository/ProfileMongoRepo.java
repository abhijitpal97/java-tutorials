package com.example.profilesetup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.profilesetup.bean.ProfileBean;

public interface ProfileMongoRepo extends MongoRepository<ProfileBean, Integer>
{
	ProfileBean findByuserId(String userId);

}
