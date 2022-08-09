package com.example.authServices.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_DETAILS")
public class UserBean {

	@Id
	@Column(name = "USERID")
	private int id;
	@Column(name = "USERNAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;


	public UserBean()
	{
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserBean(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}


}

