package com.example.addkyc.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerBean {
	
	@Id
	@SequenceGenerator(name = "custseq" , sequenceName = "CUSTOMERSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "custseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "CUSTOMERID")
	private int custId;
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	@Column(name = "CUSTOMERAGE")
	private String customerAge;
	@Column(name = "CUSTOMERMATERIALSTATUS")
	private String customerMaterialStatus;
	@Column(name = "CUSTOMERGENDER")
	private String customerGender;
	@Column(name = "CUSTOMERNATIONALITY")
	private String customerNationality;
	@Column(name = "CUSTOMERRELIGION")
	private String customerReligion;
	
	
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "customer")
	@JsonManagedReference
	KycDetailsBean kyc;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
	@JsonManagedReference
	List<AccountBean> account;

	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
	@JsonManagedReference
	List<AddressBean> address;
	
		
	public List<AddressBean> getAddress() {
		return address;
	}

	public void setAddress(List<AddressBean> address) {
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerMaterialStatus() {
		return customerMaterialStatus;
	}

	public void setCustomerMaterialStatus(String customerMaterialStatus) {
		this.customerMaterialStatus = customerMaterialStatus;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerNationality() {
		return customerNationality;
	}

	public void setCustomerNationality(String customerNationality) {
		this.customerNationality = customerNationality;
	}

	public String getCustomerReligion() {
		return customerReligion;
	}

	public void setCustomerReligion(String customerReligion) {
		this.customerReligion = customerReligion;
	}

	public KycDetailsBean getKyc() {
		return kyc;
	}

	public void setKyc(KycDetailsBean kyc) {
		this.kyc = kyc;
	}

	public List<AccountBean> getAccount() {
		return account;
	}

	public void setAccount(List<AccountBean> account) {
		this.account = account;
	}
	

	
}
