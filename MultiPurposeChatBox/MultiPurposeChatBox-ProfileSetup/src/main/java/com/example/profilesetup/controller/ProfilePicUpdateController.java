package com.example.profilesetup.controller;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.profilesetup.bean.ProfileBean;
import com.example.profilesetup.service.ProfileServices;
import com.example.profilesetup.utility.Utility;

@RestController
@RequestMapping("/profilesetup/v1")
public class ProfilePicUpdateController {
	
	@Autowired
	ProfileServices services;
	
	@Autowired
	Utility utility;
	
	@PostMapping("/setPicture")
	public String setProfilePicture(@RequestParam("userId") String userId , @RequestParam("file") MultipartFile file) throws IOException
	{
		ProfileBean profile = new ProfileBean();
		profile.setUserId(userId);
		profile.setProfilepic( new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		if(utility.validateFileType("Image" , file.getOriginalFilename().split("\\.")[1]))
			return services.setProfilePicture(profile);
		else
			return "Please upload a valid File. Allowed types are - JPEG, JPG , JPG , PNG.";
	}

}
