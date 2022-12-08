package com.example.authentication.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.authentication.bean.AuthRequest;
import com.example.authentication.bean.UserBean;
import com.example.authentication.exception.NotaValidCredentialException;
import com.example.authentication.service.FindServices;
import com.example.authentication.service.SignUpService;
import com.example.authentication.utility.JWTUtility;

@RestController
public class AuthController {

	@Autowired
	JWTUtility jutil;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	SignUpService services;
	
	@Autowired
	FindServices findServices;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest auth)
	{
		try
		{
			authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));
			return jutil.generateToken(auth.getUserName());
		}
		catch (com.example.authentication.exception.NotaValidCredentialException e) {
			throw new NotaValidCredentialException("Invalid Credentials");
		}
		catch (Exception e) {
			return "User/Password Issue. Check the details again.";
		}
	}
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserBean user)
	{
		return services.addUser(user);
	}
	
	@PutMapping("/setPassword")
	public String updatePassword(@RequestBody Map<String, Object> userMap)
	{
		return services.updatePassword((int) userMap.get("userId") , (String) userMap.get("password"));
	}
	
	@PutMapping("/updateProfile")
	public String updateProfile(@RequestBody Map<String, Object> userMap)
	{
		return services.updateProfile(userMap , "update");
		
	}
	
	@PutMapping("/deleteAccount")
	public String deleteAccount(@RequestBody Map<String, Object> userMap)
	{
		
		if(((String) userMap.get("delete")).equals("T")) 
		{
			userMap.remove("delete");
			userMap.put("isActive", "N");
			
			return services.updateProfile(userMap , "delete");
		}
		else return services.deleteAccount((int) userMap.get("userId"));
	}
	
	@PutMapping("/activateProfile")
	public String activateProfile(@RequestBody Map<String, Object> userMap)
	{
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();     
		Optional<UserBean> optional = findServices.getUserDetails(userMap);
		if(! optional.isPresent()) return "UserId not present";
		else
		{
			UserBean bean = optional.get();
			if(((String) userMap.get("userName")).equals(bean.getFirstName()) 
					&& 
					(passwordEncoder.matches((String) userMap.get("password"),bean.getPassword()))
					) 
			{
				userMap.remove("userName");
				userMap.remove("password");
				userMap.put("isActive", "Y");
				return services.updateProfile(userMap , "update");
			}
			else return "Wrong UserInfo Provided !!";
		}
		
		
	}
}
