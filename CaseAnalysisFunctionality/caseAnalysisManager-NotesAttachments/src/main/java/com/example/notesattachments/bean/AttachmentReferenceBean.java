package com.example.notesattachments.bean;

import javax.persistence.Id;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Attachments")
public class AttachmentReferenceBean {

	@Id
	private ObjectId id;
	private int attachmentRefereceId;
	private Binary image;
	
	
	public ObjectId  getId() {
		return id;
	}
	public void setId(ObjectId  id) {
		this.id = id;
	}
	public int getAttachmentRefereceId() {
		return attachmentRefereceId;
	}
	public void setAttachmentRefereceId(int attachmentRefereceId) {
		this.attachmentRefereceId = attachmentRefereceId;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	
	
}
