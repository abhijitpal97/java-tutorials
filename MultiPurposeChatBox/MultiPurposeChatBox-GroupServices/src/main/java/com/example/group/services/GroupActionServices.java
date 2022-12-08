package com.example.group.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.group.bean.GroupDetailsBean;
import com.example.group.bean.GroupUserBean;
import com.example.group.interfaces.GroupActionInterface;
import com.example.group.interfaces.GroupActionJPARepo;
import com.example.group.interfaces.GroupUserJPARepo;
import com.example.group.utility.GenericUtility;

@Service
public class GroupActionServices implements GroupActionInterface{

	@Autowired
	GroupActionJPARepo repo;
	
	@Autowired
	GroupUserJPARepo usergrouprepo;
	
	@Autowired
	GroupFindServices findservices;
	
	@Autowired
	GenericUtility utility;
	
	@Transactional
	@Override
	public String creategroup(GroupDetailsBean groupDetails) {
		groupDetails.setCreateDate(utility.generateDate());
		GroupDetailsBean bean = repo.save(groupDetails);
		
		if(bean !=null)
		{
			GroupUserBean newbean = new GroupUserBean();
			newbean.setGroupId(bean.getGroupId());
			newbean.setUserId(bean.getCreatedUserId());
			newbean.setIsadmin(1);
			usergrouprepo.save(newbean);
		}
		return "Group - "+bean.getGroupName()+" has been created successfully.";
	}
	@Override
	public String deleteGroup(int groupId) {
		
		GroupDetailsBean bean = findservices.findgroupbyId(groupId);
		if(bean !=null)
		{
			bean.setDeleteDate(utility.generateDate());
			bean.setIsGroupActive("N");
			
			bean = repo.save(bean);
			
			return "Group - "+bean.getGroupName()+ " deleted successfully !!";
		}
		else
		{
			return "Please check and provide right GroupId/Name. No such record find.";
		}
		
	}
	@Override
	public String editGroup(GroupDetailsBean groupDetails) {
		GroupDetailsBean bean = findservices.findgroupbyId(groupDetails.getGroupId());
		if(bean !=null)
		{
			bean.setGroupName(groupDetails.getGroupName());
			bean = repo.save(bean);
			
			return "Group Name - "+bean.getGroupName()+ " updated successfully !!";
		}
		else
		{
			return "Please Try Again. Seems to be some issue while updating.";
		}
	}
	@Override
	public String editGroupDesc(GroupDetailsBean groupDetails) {

		GroupDetailsBean bean = findservices.findgroupbyId(groupDetails.getGroupId());
		if(bean !=null)
		{
			bean.setGroupdescription(groupDetails.getGroupdescription());
			repo.save(bean);
			
			return "Group Description updated successfully !!";
		}
		else
		{
			return "Please Try Again. Seems to be some issue while updating.";
		}
	
	}
	@Override
	public String updateGroupSettings(int groupId , int status , int userId) {
		List<GroupUserBean> groupuserbean = usergrouprepo.findByGroupIdAndUserIdAndIsadmin(groupId, userId , 1);
		List<Integer> allowedUser = new ArrayList<>();
		groupuserbean.forEach(
				u -> allowedUser.add(u.getUserId())
				);
		
		if(allowedUser.contains(userId))
		{
			GroupDetailsBean bean = findservices.findgroupbyId(groupId);
			if(bean !=null)
			{
				bean.setIsPrivateGroup(status);
				bean = repo.save(bean);
				return "Group has been set as - "+bean.getIsPrivateGroup()=="Y"?"Private":"Public";
			}
			else
			{
				return "Please Try Again. Seems to be some issue while updating.";
			}
		}
		else
		{
			return "You are not authorize to change teh Group Settings";
		}
		
		
	}
	
	
}
