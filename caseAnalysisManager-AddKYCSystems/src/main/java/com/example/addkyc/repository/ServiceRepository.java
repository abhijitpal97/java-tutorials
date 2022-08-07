package com.example.addkyc.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.addkyc.bean.CustomerBean;

public interface ServiceRepository {
	
	CompletableFuture<CustomerBean> addCustomer(CustomerBean customer);

}
