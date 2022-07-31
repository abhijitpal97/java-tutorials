package com.example.addConfig.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.addConfig.bean.BUConfigurationBean;
import com.example.addConfig.bean.ConfigurationBean;
import com.example.addConfig.repo.BUAddRepository;
import com.example.addConfig.repo.BURepository;
import com.example.addConfig.repo.ConfigurationRepository;
import com.example.addConfig.repo.Repository;


@Service
public class ConfigAddService implements ConfigurationRepository , BUAddRepository{

	@Autowired
	Repository repo;
	@Autowired
	BURepository buRepo;



	@CacheEvict(value="configurations",  allEntries = true) 
	@CachePut(value = "configurations")
	@Override
	public CompletableFuture<List<ConfigurationBean>> addConfiguration(List<ConfigurationBean> config)
	{

		List<ConfigurationBean> configresult = repo.saveAll(config);

		return CompletableFuture.completedFuture(configresult);
	}


	@CacheEvict(value="buconfigurations",  allEntries = true) 
	@CachePut(value = "buconfigurations")
	@Override
	public CompletableFuture<List<BUConfigurationBean>> addBuConfiguration(List<BUConfigurationBean> config) {

		List<BUConfigurationBean> buconfigresult = buRepo.saveAll(config);
		return CompletableFuture.completedFuture(buconfigresult);


	}


}
