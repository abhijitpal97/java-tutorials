package com.example.profilesetup.bean;

import org.bson.types.Binary;

public class ProfileInformationBean {

	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String dob;
	private String gender;
	private String email;
	private Binary profilepic;
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Binary getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(Binary profilepic) {
		this.profilepic = profilepic;
	}
	
	
	
}
