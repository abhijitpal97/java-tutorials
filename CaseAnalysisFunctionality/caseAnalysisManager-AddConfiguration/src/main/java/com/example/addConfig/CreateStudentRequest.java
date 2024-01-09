package com.example.addConfig;

import java.util.List;


public class CreateStudentRequest {

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<CreateSubjectRequest> subjectsLearning;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<CreateSubjectRequest> getSubjectsLearning() {
		return subjectsLearning;
	}

	public void setSubjectsLearning(List<CreateSubjectRequest> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}
	
	

}
