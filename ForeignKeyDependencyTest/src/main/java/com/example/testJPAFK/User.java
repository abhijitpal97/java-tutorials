package com.example.testJPAFK;

import javax.persistence.*;

@Entity
@Table(name = "USERTABLE")
public class User {

	@Id
	@SequenceGenerator(name = "USERSEQUENCE" , sequenceName = "USERSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "USERSEQUENCE" , strategy = GenerationType.SEQUENCE)
	@Column(name = "USERID")
	private int userId;
	@Column(name = "NAME")
	private String name;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
	
	
}
