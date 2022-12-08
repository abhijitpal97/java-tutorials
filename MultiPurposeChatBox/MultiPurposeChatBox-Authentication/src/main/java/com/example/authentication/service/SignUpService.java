package com.example.authentication.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.bean.UserBean;
import com.example.authentication.repository.AddRepository;
import com.example.authentication.repository.JPARepository;
import com.example.authentication.utility.GenericUtilityClass;

@Service
public class SignUpService implements AddRepository{

	@Autowired
	GenericUtilityClass utility;

	@Autowired
	JPARepository repository;

	@Override
	public String addUser(UserBean user) {
		String password = utility.generateRandomPassword();
		user.setPassword(password);
		user.setCreateDate(utility.generateDate());
		try
		{
			UserBean userDetails = repository.save(user);
			return "Profile for User - "+userDetails.getFirstName()+" "+user.getLastName()+" has been created with default password - "+password+" . Change your password before proceed.";	
		}
		catch (Exception e) {
			return "It's not you. It's us. Some issue while creating the profile. We are working on the same.";
		}
	}

	@Override
	public String updatePassword(int userId, String password) {

		Optional<UserBean> optional = repository.findById(userId);

		if(! optional.isPresent()) return "UserId not Present";
		else
		{
			UserBean user = optional.get();
			user.setPassword(password);
			user.setPasswordReset("Y");
			user.setLastUpdate(utility.generateDate());
			try
			{
				System.out.println(user);
				UserBean userDetails = repository.save(user);
				return "Profile Password for User - "+userDetails.getFirstName()+" "+user.getLastName()+" has been updated";
			}
			catch (Exception e) {
				return "It's not you. It's us. Some issue while creating the profile. We are working on the same.";
			}

		}


	}

	@Override
	public String updateProfile(Map<String, Object> userMap  , String action) {
		Optional<UserBean> optional = repository.findById((int) userMap.get("userId"));
		if(! optional.isPresent()) return "UserId not Present";
		else
		{
			UserBean user = optional.get();
			userMap.forEach(
					(key,value) ->
					{
						if(key.equals("lastName"))
							user.setLastName((String) value);
						if(key.equals("mobileNumber"))
							user.setMobileNumber((long) value);
						if(key.equals("emailId"))
							user.setEmail((String) value);
						if(key.equals("isActive"))
							user.setIsActive((String) value);
					}

					);
			if(action.equalsIgnoreCase("delete"))  user.setDeleteDate(utility.generateDate());
			try
			{
				System.out.println(user);
				user.setLastUpdate(utility.generateDate());
				UserBean userDetails = repository.save(user);
				return "Profile Details succesffully updated for User - "+userDetails.getFirstName()+" "+user.getLastName();
			}
			catch (Exception e) {
				return "It's not you. It's us. Some issue while creating the profile. We are working on the same.";
			}

		}
	}

	@Override
	public String deleteAccount(int userId) {
		try
		{
			repository.deleteById(userId);
			return "User Deleted succsessfully.";
		}
		catch (Exception e) {
			return "It's not you. It's us. Some issue while deleting the profile. We are working on the same.";
		}


	}



}
