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
@Table(name = "ACCOUNT_DETAILS")
public class AccountBean {
	
	@Id
	@SequenceGenerator(name = "acctseq" , sequenceName = "ACCOUNTSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "acctseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "ACCOUNTID")
	private int accountId;
	@Column(name = "ACCOUNTHOLDERNAME")
	private String accountHolderName;
	@Column(name = "ACCOUNTTYPE")
	private String accountType;
	@Column(name = "ACCOUNTNUMBER")
	private String accountNumber;
	@Column(name = "BALANCE")
	private String balance;
	@Column(name = "ACCOUNTSCORE")
	private String accountScore;
	@Column(name = "ACCOUNTSTATUS")
	private String accountStatus;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMERID")
	@JsonBackReference
	private CustomerBean customer ;
	
	
	
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAccountScore() {
		return accountScore;
	}
	public void setAccountScore(String accountScore) {
		this.accountScore = accountScore;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	

}
