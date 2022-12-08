package com.example.authentication.repository;

import java.util.Map;

import com.example.authentication.bean.UserBean;

public interface AddRepository {

	public String addUser(UserBean user);
	public String updatePassword(int userId, String password);
	public String updateProfile(Map<String, Object> userMap , String action);
	public String deleteAccount(int i);
}
