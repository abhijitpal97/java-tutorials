package com.example.authServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authServices.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean, Integer>{

	UserBean findByname(String name);
}
