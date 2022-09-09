package com.example.notesattachments.bean;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ATTACHMENTS")
public class AttachmentBean {
	
	@Id
	@SequenceGenerator(name = "attachmentseq" ,sequenceName = "ATTACHMENTSEQUENCE" ,allocationSize = 1 , initialValue = 100)
	@GeneratedValue(generator = "attachmentseq" , strategy = GenerationType.SEQUENCE)
	private int ATTACHMENTINTERNALID;
	private String ALERTID;
	private String ADDEDBY;
	private Date ADDTIME = new Date();;
	private String ATTACHMENT;
	public int getATTACHMENTINTERNALID() {
		return ATTACHMENTINTERNALID;
	}
	public void setATTACHMENTINTERNALID(int aTTACHMENTINTERNALID) {
		ATTACHMENTINTERNALID = aTTACHMENTINTERNALID;
	}
	public String getALERTID() {
		return ALERTID;
	}
	public void setALERTID(String aLERTID) {
		ALERTID = aLERTID;
	}
	public String getADDEDBY() {
		return ADDEDBY;
	}
	public void setADDEDBY(String aDDEDBY) {
		ADDEDBY = aDDEDBY;
	}
	public Date getADDTIME() {
		return ADDTIME;
	}
	public void setADDTIME(Date aDDTIME) {
		ADDTIME = aDDTIME;
	}
	
	public String getATTACHMENT() {
		return ATTACHMENT;
	}
	public void setATTACHMENT(String aTTACHMENT) {
		ATTACHMENT = aTTACHMENT;
	}
	@Override
	public String toString() {
		return "AttachmentBean [ATTACHMENTINTERNALID=" + ATTACHMENTINTERNALID + ", ALERTID=" + ALERTID + ", ADDEDBY="
				+ ADDEDBY + ", ADDTIME=" + ADDTIME + ", ATTACHMENT=" + ATTACHMENT + "]";
	}
	
	
	
	

}
