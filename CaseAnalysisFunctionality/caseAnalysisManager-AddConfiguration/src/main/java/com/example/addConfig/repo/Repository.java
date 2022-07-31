package com.example.addConfig.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addConfig.bean.ConfigurationBean;

public interface Repository extends JpaRepository<ConfigurationBean, Integer>{

	List<ConfigurationBean> findAllByconfigkey(String key);
	List<ConfigurationBean> findAllByregion(String region);

}
