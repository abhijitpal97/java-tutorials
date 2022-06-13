package com.example.loginmodule.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Id
	private String id;
	private String user;
	private String emailId;
	private String password;
	private String isActive;
	private Role roles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	@PersistenceConstructor
	public User(String id, String user, String emailId, String password, String isActive, Role roles) {
		super();
		id = id;
		this.user = user;
		this.emailId = emailId;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [Id=" + id + ", user=" + user + ", emailId=" + emailId + ", password=" + password + ", isActive="
				+ isActive + ", roles=" + roles + "]";
	}
	
	
}
