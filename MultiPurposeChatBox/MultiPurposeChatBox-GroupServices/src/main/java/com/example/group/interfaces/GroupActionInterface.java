package com.example.group.interfaces;

import com.example.group.bean.GroupDetailsBean;

public interface GroupActionInterface {
	
	public String creategroup(GroupDetailsBean groupDetails);
	public String deleteGroup(int groupId);
	public String editGroup(GroupDetailsBean groupDetails);
	public String editGroupDesc(GroupDetailsBean groupDetails);
	public String updateGroupSettings(int groupId, int status, int userId);

}
