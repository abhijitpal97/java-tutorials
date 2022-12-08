package com.example.group.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "GROUPDETAILS")
public class GroupDetailsBean {
	
	@Id
	@SequenceGenerator(name = "groupseq" , sequenceName = "GROUPSEQUENCE" , initialValue = 1 , allocationSize = 1)
	@GeneratedValue(generator = "groupseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "GROUPID")
	private int groupId;
	@Column(name = "GROUPNAME")
	private String groupName;
	@Column(name = "GROUPDESCRIPTION")
	private String groupdescription;
	@Column(name = "HASGROUPPIC")
	private String hasGroupPic="N";
	@Column(name = "ISGROUPACTIVE")
	private String isGroupActive="Y";
	@Column(name = "CREATEDATE")
	private String createDate;
	@Column(name = "DELETEDATE")
	private String deleteDate;
	@Column(name = "CREATEDBY")
	private int createdUserId;
	@Column(name = "ISPRIVATE")
	private int isPrivateGroup=0;
	
	
	public int getIsPrivateGroup() {
		return isPrivateGroup;
	}
	public void setIsPrivateGroup(int isPrivateGroup) {
		this.isPrivateGroup = isPrivateGroup;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupdescription() {
		return groupdescription;
	}
	public void setGroupdescription(String groupdescription) {
		this.groupdescription = groupdescription;
	}
	public String getHasGroupPic() {
		return hasGroupPic;
	}
	public void setHasGroupPic(String hasGroupPic) {
		this.hasGroupPic = hasGroupPic;
	}
	public String getIsGroupActive() {
		return isGroupActive;
	}
	public void setIsGroupActive(String isGroupActive) {
		this.isGroupActive = isGroupActive;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}
	@Override
	public String toString() {
		return "GroupDetailsBean [groupId=" + groupId + ", groupName=" + groupName + ", groupdescription="
				+ groupdescription + ", hasGroupPic=" + hasGroupPic + ", isGroupActive=" + isGroupActive
				+ ", createDate=" + createDate + ", deleteDate=" + deleteDate + ", createdUserId=" + createdUserId
				+ ", isPrivateGroup=" + isPrivateGroup + "]";
	}
	
	
		
}
