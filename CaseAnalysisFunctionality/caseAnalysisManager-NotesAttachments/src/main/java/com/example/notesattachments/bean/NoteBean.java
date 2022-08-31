package com.example.notesattachments.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NOTES")
public class NoteBean {
	
	@Id
	@SequenceGenerator(name = "noteseq" , sequenceName = "NOTESEQUENCE" , allocationSize = 1 , initialValue = 100)
	@GeneratedValue(generator = "noteseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "NOTEINTERNALID")
	private int noteInternalId;
	@Column(name = "ALERTID")
	private int alertId;
	@Column(name = "ADDEDBY")
	private String addedBy;
	@Column(name = "NOTES")
	private String notes;
	@Column(name = "ADDTIME")
	private Date addTime = new Date();
	public int getNoteInternalId() {
		return noteInternalId;
	}
	public void setNoteInternalId(int noteInternalId) {
		this.noteInternalId = noteInternalId;
	}
	public int getAlertId() {
		return alertId;
	}
	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "NoteBean [noteInternalId=" + noteInternalId + ", alertId=" + alertId + ", addedBy=" + addedBy
				+ ", notes=" + notes + ", addTime=" + addTime + "]";
	}
	
	
	
}
