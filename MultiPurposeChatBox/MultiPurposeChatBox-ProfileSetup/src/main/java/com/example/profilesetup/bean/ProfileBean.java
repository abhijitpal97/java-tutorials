package com.example.profilesetup.bean;

import javax.persistence.Id;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProfilePictures")
public class ProfileBean {
	
	@Id
	private ObjectId id;
	private String userId;
	private Binary profilepic;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Binary getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(Binary profilepic) {
		this.profilepic = profilepic;
	}

	
}

