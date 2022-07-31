package com.example.addConfig.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.addConfig.bean.ConfigurationBean;

public interface ConfigurationRepository {
	
	CompletableFuture<List<ConfigurationBean>> addConfiguration(List<ConfigurationBean> config);
}
