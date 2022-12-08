package com.example.profilesetup.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.bcrypt.BCrypt;


@Entity
@DynamicUpdate
@Table(name = "CHATUSERDETAILS")
public class UserBean {

	@Id
	@SequenceGenerator(name = "userseq" , sequenceName = "CHATUSERSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "userseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "USERID")
	private int id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "MOBILENUMBER")
	private long mobileNumber;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "ISACTIVE")
	private String isActive = "Y";
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORDRESET")
	private String passwordReset = "N";
	@Column(name = "CREATEDATE")
	private String createDate;
	@Column(name = "DELETEDATE")
	private String deleteDate;
	@Column(name = "LASTUPDATE")
	private String lastUpdate;
	@Column(name = "HASPROFILEPIC")
	private String hasProfilePic;
	
	public UserBean()
	{
	}


	
	public String getPasswordReset() {
		return passwordReset;
	}


	public void setPasswordReset(String passwordReset) {
		this.passwordReset = passwordReset;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}


	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public String getDeleteDate() {
		return deleteDate;
	}



	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	public String getLastUpdate() {
		return lastUpdate;
	}



	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}



	public String getHasProfilePic() {
		return hasProfilePic;
	}



	public void setHasProfilePic(String hasProfilePic) {
		this.hasProfilePic = hasProfilePic;
	}



	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", gender=" + gender + ", isActive=" + isActive + ", password="
				+ password + ", email=" + email + ", passwordReset=" + passwordReset + ", createDate=" + createDate
				+ ", deleteDate=" + deleteDate + ", lastUpdate=" + lastUpdate + ", getPasswordReset()="
				+ getPasswordReset() + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMobileNumber()=" + getMobileNumber() + ", getDob()="
				+ getDob() + ", getGender()=" + getGender() + ", getIsActive()=" + getIsActive() + ", getPassword()="
				+ getPassword() + ", getCreateDate()=" + getCreateDate() + ", getDeleteDate()=" + getDeleteDate()
				+ ", getEmail()=" + getEmail() + ", getLastUpdate()=" + getLastUpdate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	

}

