package com.example.group.interfaces;

import java.util.List;

import com.example.group.bean.GroupDetailsBean;
import com.example.group.bean.GroupUserBean;

public interface GroupFindInterface {
	
	public GroupDetailsBean findgroupbyId(int groupId);
	public List<GroupDetailsBean> findGroupForUser(int userId);
	public List<GroupUserBean> findGroupUsers(int groupId);

}
