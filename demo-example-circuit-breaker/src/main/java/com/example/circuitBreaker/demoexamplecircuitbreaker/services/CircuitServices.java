package com.example.circuitBreaker.demoexamplecircuitbreaker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.circuitBreaker.demoexamplecircuitbreaker.bean.EmployeeBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CircuitServices {
	
	@HystrixCommand(fallbackMethod = "defaultmessage")
	public String getMessage() {
        return new RestTemplate()
          .getForObject("http://localhost:8081/employees/message", 
          String.class);
    }
 
    public String defaultmessage() {
        return "This is a circuit Breaker Instance !!";
    }

    @HystrixCommand(fallbackMethod = "defaultBean")
	public EmployeeBean getEmployee(int id) {
    	System.out.println(id);
    	 EmployeeBean bean =  new RestTemplate()
    	          .getForObject("http://localhost:8081/employees/"+id+"/employee", 
    	          EmployeeBean.class, id);
    	 System.out.println(bean);
    	 return bean;
    }
    
    public EmployeeBean defaultBean(int id)
    {
    	System.out.println("123");
    	return null;
    }
    
    public EmployeeBean defaultBean()
    {
    	System.out.println("1234");
    	return null;
    }
    
    public List<EmployeeBean> defaultListBean()
    {
    	List<EmployeeBean> list = new ArrayList<EmployeeBean>();
    	EmployeeBean bean = new EmployeeBean(999, "Test");
    	list.add(bean);
    	return list;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@HystrixCommand(fallbackMethod = "defaultListBean")
	public List<EmployeeBean> getEmployees() {
    	System.out.println("Inside This - ");
    	ResponseEntity<List> response =  new RestTemplate()
    			.getForEntity("http://localhost:8081/employees/employees",  List.class);
    	List<EmployeeBean> beans = response.getBody(); 
    	System.out.println(beans);
    	 return beans;
    
	}
	

}
