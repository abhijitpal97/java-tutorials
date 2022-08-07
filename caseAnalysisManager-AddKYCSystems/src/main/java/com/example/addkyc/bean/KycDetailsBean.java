package com.example.addkyc.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "KYC_DETAILS")
public class KycDetailsBean {

	@Id
	@Column(name = "UIDNUMBER")
	private String uidNumber;
	@Column(name = "UIDREFERENCE")
	private String uidReference;
	@Column(name = "REFERENCEAPPROVER")
	private String referenceApprover;

	
	// One-to-One Reference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMERID")
	@JsonBackReference
	private CustomerBean customer;


	public String getUidNumber() {
		return uidNumber;
	}


	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	
	
	public String getUidReference() {
		return uidReference;
	}


	public void setUidReference(String uidReference) {
		this.uidReference = uidReference;
	}


	public String getReferenceApprover() {
		return referenceApprover;
	}


	public void setReferenceApprover(String referenceApprover) {
		this.referenceApprover = referenceApprover;
	}


	public CustomerBean getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	
	
	// Many - to - one Reference
	//private AddressBean address;
	
	
	

}
