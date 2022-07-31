package com.example.addConfig.repo;

import java.util.List;

import com.example.addConfig.bean.ConfigurationBean;

public interface ConfigurationFindRepository {

	List<ConfigurationBean> findConfigurationByConfigKey(String key);
	List<ConfigurationBean> findConfigurationByregion(String region);

}
