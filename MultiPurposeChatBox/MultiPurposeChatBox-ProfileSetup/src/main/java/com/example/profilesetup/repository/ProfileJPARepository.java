package com.example.profilesetup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.profilesetup.bean.UserBean;

public interface ProfileJPARepository extends JpaRepository<UserBean, Integer>{
	UserBean findByFirstName(String firstName);

}
