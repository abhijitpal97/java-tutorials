package com.example.addConfig.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addConfig.bean.UserBean;

public interface UserRepo extends JpaRepository<UserBean, Integer>{
	
	List<UserBean> findAllByname(String name);

}
