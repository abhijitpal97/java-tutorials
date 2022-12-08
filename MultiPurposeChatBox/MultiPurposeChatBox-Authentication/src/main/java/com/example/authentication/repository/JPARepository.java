package com.example.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authentication.bean.UserBean;

public interface JPARepository extends JpaRepository<UserBean, Integer>{

	UserBean findByFirstNameAndIsActive(String firstName , String isActive);

	
}
