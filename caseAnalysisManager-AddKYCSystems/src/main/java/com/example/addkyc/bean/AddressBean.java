package com.example.addkyc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ADDRESS_DETAILS")
public class AddressBean {
	
	@Id
	@SequenceGenerator(name = "addrseq" , sequenceName = "ADDRESSSEQUENCE" , allocationSize = 1 , initialValue = 1)
	@GeneratedValue(generator = "addrseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "ADDRESSID")
	private int addressId;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "STATE")
	private String state;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "POSTALCODE")
	private String postalcode;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMERID")
	@JsonBackReference
	private CustomerBean customer;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	
	
	

}
