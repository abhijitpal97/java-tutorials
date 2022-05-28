package com.example.microservice2.bean;

public class EmployeeBean {
	private int employeeId;
	private String employeeName;
	private String details;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public EmployeeBean(int employeeId, String employeeName, String details) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.details = details;
	}
	@Override
	public String toString() {
		return "EmployeeBean [employeeId=" + employeeId + ", employeeName=" + employeeName + ", details=" + details
				+ "]";
	}
	
	
}
