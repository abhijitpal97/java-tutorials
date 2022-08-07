package com.example.addkyc.repository;

import com.example.addkyc.bean.CustomerBean;

public interface FindServiceRepository {
	
	CustomerBean getCustomerBean(int id);

}
