package com.example.addConfig.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESSUNITS")
public class BUConfigurationBean {
	
	@Id
	@SequenceGenerator(name = "buseq" , sequenceName = "BUSEQUENCE" ,initialValue = 1000 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "buseq")
	@Column(name = "BU_INTERNAL_ID")
	private int buInternalId;
	@Column(name = "BU_NAME")
	private String buName;
	@Column(name = "REGION")
	private String region;
	
	public int getBuInternalId() {
		return buInternalId;
	}
	public void setBuInternalId(int buInternalId) {
		this.buInternalId = buInternalId;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	
}
