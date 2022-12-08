package com.example.group.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositeKey.class)
@Table(name = "GROUPUSERDETAILS")
public class GroupUserBean {
	
	@Id
	@Column(name = "GROUPID")
	private int groupId;
	@Id
	@Column(name = "USERID")
	private int userId;
	@Column(name = "ISADMIN")
	private int isadmin;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	@Override
	public String toString() {
		return "GroupUserBean [groupId=" + groupId + ", userId=" + userId + ", isadmin=" + isadmin + "]";
	}
	
	
}
