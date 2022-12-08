package com.example.group.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.group.bean.GroupDetailsBean;
import com.example.group.bean.GroupUserBean;
import com.example.group.interfaces.GroupActionJPARepo;
import com.example.group.interfaces.GroupFindInterface;
import com.example.group.interfaces.GroupUserJPARepo;

@Service
public class GroupFindServices implements GroupFindInterface{

	@Autowired
	GroupActionJPARepo repo;
	
	@Autowired
	GroupUserJPARepo groupuserrepo;
	
	@Override
	public GroupDetailsBean findgroupbyId(int groupId) {
		Optional<GroupDetailsBean> optionalBean= repo.findById(groupId);
		return optionalBean.isPresent() ? optionalBean.get():null;
	}

	@Override
	public List<GroupDetailsBean> findGroupForUser(int userId) {
		List<GroupUserBean> beans = groupuserrepo.findByUserId(userId);
		List<GroupDetailsBean> beanResult = new ArrayList<>();
		
		beans.forEach(
				t -> 
				{
					GroupDetailsBean bean = findgroupbyId(t.getGroupId());
					if(bean.getIsGroupActive().equalsIgnoreCase("Y")) beanResult.add(bean);
				}
				);
		
		return beanResult;
		
	}

	@Override
	public List<GroupUserBean> findGroupUsers(int groupId) {
		return groupuserrepo.findByGroupId(groupId);
	}
	
	

}
