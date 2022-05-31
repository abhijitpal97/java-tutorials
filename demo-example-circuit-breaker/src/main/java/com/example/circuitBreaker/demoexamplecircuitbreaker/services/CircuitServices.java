package com.example.circuitBreaker.demoexamplecircuitbreaker.services;

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
	

}
