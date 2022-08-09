package com.example.addConfig.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.addConfig.bean.UserBean;

public interface AddUserRepository {
	
	CompletableFuture<List<UserBean>> addUsers(List<UserBean> config);

}
