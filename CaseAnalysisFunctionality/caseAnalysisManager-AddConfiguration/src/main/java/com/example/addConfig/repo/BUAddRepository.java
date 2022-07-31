package com.example.addConfig.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.addConfig.bean.BUConfigurationBean;

public interface BUAddRepository {
	
	CompletableFuture<List<BUConfigurationBean>> addBuConfiguration(List<BUConfigurationBean> config);

}
