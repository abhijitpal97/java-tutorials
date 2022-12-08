package com.example.profilesetup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profilesetup.bean.ProfileBean;
import com.example.profilesetup.bean.UserBean;
import com.example.profilesetup.repository.ProfileJPARepository;
import com.example.profilesetup.repository.ProfileMongoRepo;
import com.example.profilesetup.repository.ProfilePictureRepository;

@Service
public class ProfileServices implements ProfilePictureRepository{

	@Autowired
	ProfileMongoRepo mongoRepo;

	@Autowired
	ProfileJPARepository jpaRepo;

	@Override
	public String setProfilePicture(ProfileBean profile) {
		UserBean user = jpaRepo.findByFirstName(profile.getUserId());
		if(user != null)
		{
			ProfileBean bean = mongoRepo.save(profile);
			if(bean.getId() != null)
			{
				user.setHasProfilePic("Y");
				try
				{
					jpaRepo.save(user);
					return "Profile Picture Stored successfully for User with Object Reference - "+bean.getId();
				}
				catch (Exception e) {
					mongoRepo.delete(profile);
					return "Issue in data persist. Please try again agter sometime.";			
				}					
			}
			else
				return "Some issue while store data in DB. Please try after sometime.";

		}
		else
			return "Chcek with the right Input params. Something wrong with teh given data.";
	}

}