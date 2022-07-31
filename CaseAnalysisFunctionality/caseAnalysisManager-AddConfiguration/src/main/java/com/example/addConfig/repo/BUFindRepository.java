package com.example.addConfig.repo;

import java.util.List;

import com.example.addConfig.bean.BUConfigurationBean;

public interface BUFindRepository {
	
	List<BUConfigurationBean> findConfigurationBybuName(String name);
	List<BUConfigurationBean> findConfigurationByburegion(String region);

}
