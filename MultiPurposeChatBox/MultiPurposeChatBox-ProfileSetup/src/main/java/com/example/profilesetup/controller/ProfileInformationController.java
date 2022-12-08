package com.example.profilesetup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profilesetup.bean.ProfileInformationBean;
import com.example.profilesetup.service.ProfileInformationServices;

@RestController
@RequestMapping("/profilesetup/v1")
public class ProfileInformationController {
	
	@Autowired
	ProfileInformationServices service;
	
	@GetMapping("/getProfileInformation")
	public ProfileInformationBean getProfileInformation(@RequestBody String userId)
	{
		return service.getProfileInformation(userId);
	}

}
