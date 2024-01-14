package com.example.addConfig.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.addConfig.ResponseObject;
import com.example.addConfig.Student;
import com.example.addConfig.StudentRepository;
import com.example.addConfig.bean.BUConfigurationBean;
import com.example.addConfig.bean.ConfigurationBean;
import com.example.addConfig.bean.UserBean;
import com.example.addConfig.repo.BUFindRepository;
import com.example.addConfig.repo.BURepository;
import com.example.addConfig.repo.ConfigurationFindRepository;
import com.example.addConfig.repo.ConfigurationRepository;
import com.example.addConfig.repo.FindUserRepository;
import com.example.addConfig.repo.Repository;
import com.example.addConfig.repo.UserRepo;


@Service
public class ConfigFindService implements ConfigurationFindRepository,BUFindRepository,FindUserRepository{

	@Autowired
	Repository repo;
	@Autowired
	BURepository buRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	StudentRepository stuRepo;
	
	@Cacheable(value = "configurations")
	@Override
	public List<ConfigurationBean> findConfigurationByConfigKey(String configkey) {
		System.out.println("Inside Find Cache System");
		return repo.findAllByconfigkey(configkey);
	}

	@Cacheable(value = "configurations")
	@Override
	public List<ConfigurationBean> findConfigurationByregion(String region) {
		System.out.println("Inside Find Region-Config Cache System");
		return repo.findAllByregion(region);
	}
	
	
	@Cacheable(value = "buconfigurations")
	@Override
	public List<BUConfigurationBean> findConfigurationBybuName(String name) {
		System.out.println("Inside Find Bu Cache System");
		return buRepo.findAllBybuName(name);
	}

	
	@Cacheable(value = "buconfigurations")
	@Override
	public List<BUConfigurationBean> findConfigurationByburegion(String region) {

		System.out.println("Inside Find Bu Region Cache System");
		return buRepo.findAllByregion(region);


	}

	@Override
	public List<UserBean> findUserByname(String name) {
		return userRepo.findAllByname(name);
	}

	
	public List<ResponseObject> findDetails()
	{
		List<Student> student = stuRepo.findDetails();
		String fN = student.get(0).getFirstName();
		String lN = student.get(0).getLastName();
		String cT = student.get(0).getAddress().getCity();
		ResponseObject ro = new ResponseObject();
		ro.setFirst_name(fN);
		ro.setLast_name(lN);
		ro.setCity(cT);
		return new ArrayList<>(Arrays.asList(ro));
	}
	

}
