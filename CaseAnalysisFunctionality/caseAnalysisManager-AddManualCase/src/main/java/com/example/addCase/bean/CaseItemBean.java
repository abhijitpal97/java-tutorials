package com.example.addCase.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Alerts")
public class CaseItemBean {
	
	@Id
	@SequenceGenerator(name = "alertseq" , sequenceName = "ALERTSEQUENCE" , initialValue = 1000 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "alertseq")
	private int alertinternalid;
	private String alertid;
	private String focustype;
	private String focusid;
	private String focusname;
	private String businessunit;
	private String ownername;
	private String param1;
	private String param2;
	private String param3;
	private int param4;
	private int param5;
	private int param6; 
	private Date param7;
	private Date param8;
	private Date param9;
	private String  escalationmarker;
	public int getAlertinternalid() {
		return alertinternalid;
	}
	public void setAlertinternalid(int alertinternalid) {
		this.alertinternalid = alertinternalid;
	}
	public String getAlertid() {
		return alertid;
	}
	public void setAlertid(String alertid) {
		this.alertid = alertid;
	}
	public String getFocustype() {
		return focustype;
	}
	public void setFocustype(String focustype) {
		this.focustype = focustype;
	}
	public String getFocusid() {
		return focusid;
	}
	public void setFocusid(String focusid) {
		this.focusid = focusid;
	}
	public String getFocusname() {
		return focusname;
	}
	public void setFocusname(String focusname) {
		this.focusname = focusname;
	}
	public String getBusinessunit() {
		return businessunit;
	}
	public void setBusinessunit(String businessunit) {
		this.businessunit = businessunit;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public int getParam4() {
		return param4;
	}
	public void setParam4(int param4) {
		this.param4 = param4;
	}
	public int getParam5() {
		return param5;
	}
	public void setParam5(int param5) {
		this.param5 = param5;
	}
	public int getParam6() {
		return param6;
	}
	public void setParam6(int param6) {
		this.param6 = param6;
	}
	public Date getParam7() {
		return param7;
	}
	public void setParam7(Date param7) {
		this.param7 = param7;
	}
	public Date getParam8() {
		return param8;
	}
	public void setParam8(Date param8) {
		this.param8 = param8;
	}
	public Date getParam9() {
		return param9;
	}
	public void setParam9(Date param9) {
		this.param9 = param9;
	}
	public String getEscalationmarker() {
		return escalationmarker;
	}
	public void setEscalationmarker(String escalationmarker) {
		this.escalationmarker = escalationmarker;
	}

	
}
