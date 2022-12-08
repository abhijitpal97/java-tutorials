package com.example.profilesetup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profilesetup.bean.ProfileBean;
import com.example.profilesetup.bean.ProfileInformationBean;
import com.example.profilesetup.bean.UserBean;
import com.example.profilesetup.repository.ProfileJPARepository;
import com.example.profilesetup.repository.ProfileMongoRepo;
import com.example.profilesetup.repository.ProfilePictureFindRepository;

@Service
public class ProfileInformationServices implements ProfilePictureFindRepository{
	ProfileInformationBean profileInformationBean = new  ProfileInformationBean();
	
	@Autowired
	ProfileJPARepository jpaRepo;
	
	@Autowired
	ProfileMongoRepo mongoRepo;
	
	@Override
	public ProfileInformationBean getProfileInformation(String userName) {
		UserBean user = jpaRepo.findByFirstName(userName);
		
		if(user != null)
		{
			profileInformationBean.setFirstName(user.getFirstName());
			profileInformationBean.setLastName(user.getLastName());
			profileInformationBean.setGender(user.getGender());
			profileInformationBean.setDob(user.getDob());
			profileInformationBean.setMobileNumber(user.getMobileNumber());
			profileInformationBean.setEmail(user.getEmail());
			if(user.getHasProfilePic().equalsIgnoreCase("Y")) 
			{
				ProfileBean profile = mongoRepo.findByuserId(userName);
				profileInformationBean.setProfilepic(profile.getProfilepic());
			}
			
		}
		
		return profileInformationBean;
	}

}
