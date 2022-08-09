package com.example.addConfig.repo;

import java.util.List;

import com.example.addConfig.bean.UserBean;

public interface FindUserRepository {
	
	List<UserBean> findUserByname(String name);

}
