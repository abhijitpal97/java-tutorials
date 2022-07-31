package com.example.addConfig.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addConfig.bean.BUConfigurationBean;

public interface BURepository extends JpaRepository<BUConfigurationBean, Integer>{

	List<BUConfigurationBean> findAllBybuName(String name);

	List<BUConfigurationBean> findAllByregion(String region);
	
}
