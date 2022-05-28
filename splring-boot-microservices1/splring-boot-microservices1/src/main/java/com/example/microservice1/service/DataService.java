package com.example.microservice1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservice1.bean.EmployeeBean;

@Service
public class DataService {
	static List<EmployeeBean> beanList =new ArrayList<EmployeeBean>();
	static
	{

		EmployeeBean bean1 =new EmployeeBean(1, "Abhijit");	
		EmployeeBean bean2 =new EmployeeBean(2, "Shikha");	
		EmployeeBean bean3 =new EmployeeBean(3, "Keshav");	
		EmployeeBean bean4 =new EmployeeBean(4, "Prabhas");
		beanList.add(bean1);
		beanList.add(bean2);
		beanList.add(bean3);
		beanList.add(bean4);
	}

	public EmployeeBean getEmployee(int id)
	{
		for(EmployeeBean bean : beanList)
		{
			if(bean.getEmployeeId()==id)
			{
				return bean;	
			}
		}
		return null;
	}

}
