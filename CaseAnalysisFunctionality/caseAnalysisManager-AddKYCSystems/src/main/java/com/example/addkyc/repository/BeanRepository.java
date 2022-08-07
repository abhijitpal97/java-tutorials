package com.example.addkyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addkyc.bean.CustomerBean;

public interface BeanRepository extends JpaRepository<CustomerBean, Integer>{
	
	CustomerBean findAllBycustId(int id);

}
