package com.example.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.group.bean.GroupDetailsBean;
import com.example.group.bean.GroupUserBean;
import com.example.group.services.GroupFindServices;

@RestController
@RequestMapping("/groupMessageService/v1")
public class GroupFindController {
	
	@Autowired
	GroupFindServices findServices;
	
	@GetMapping("/findGroupsofUser/{userId}")
	public List<GroupDetailsBean> findGroupForUser(@PathVariable int userId)
	{
		return findServices.findGroupForUser(userId);
	}
	
	@GetMapping("/findGroupUsers/{groupId}")
	public List<GroupUserBean> findGroupUsers(@PathVariable int groupId)
	{
		return findServices.findGroupUsers(groupId);
	}

}
