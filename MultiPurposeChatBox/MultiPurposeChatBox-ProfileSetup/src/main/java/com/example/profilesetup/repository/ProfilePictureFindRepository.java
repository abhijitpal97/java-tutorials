package com.example.profilesetup.repository;

import com.example.profilesetup.bean.ProfileInformationBean;

public interface ProfilePictureFindRepository {
	
	public ProfileInformationBean getProfileInformation(String userId);

}
