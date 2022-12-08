package com.example.authentication.repository;

import java.util.Map;
import java.util.Optional;

import com.example.authentication.bean.UserBean;

public interface FindRepository {

	public Optional<UserBean> getUserDetails(Map<String, Object> userMap);
}
