package com.example.microservice2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservice2.bean.EmployeeBean;

@Service
public class DataService {
	static List<EmployeeBean> beanList =new ArrayList<EmployeeBean>();
	static
	{

		EmployeeBean bean1 =new EmployeeBean(1, "Abhijit","Created for Demo Purpose");	
		EmployeeBean bean2 =new EmployeeBean(2, "Shikha", "Second creation for Demo");	
		EmployeeBean bean3 =new EmployeeBean(3, "Keshav","Third Creation for Demo");	
		EmployeeBean bean4 =new EmployeeBean(4, "Prabhas","Forth Creation For Demo");
		beanList.add(bean1);
		beanList.add(bean2);
		beanList.add(bean3);
		beanList.add(bean4);
	}

	public EmployeeBean getEmployee(int id)
	{
		System.out.println("12345");
		for(EmployeeBean bean : beanList)
		{
			if(bean.getEmployeeId()==id)
			{
				return bean;	
			}
		}
		return null;
	}

	public EmployeeBean updateDetails(EmployeeBean employee) {
		int id = employee.getEmployeeId();
		String desc = employee.getDetails();
		EmployeeBean bean = getEmployee(id);
		if(null == bean)
		{
			EmployeeBean newBean = new EmployeeBean(id, employee.getEmployeeName(), desc);
			return newBean;
		}
		else
		{
			bean.setDetails(desc);
			return  bean;
		}
		
	}

}
