package com.example.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.group.bean.GroupDetailsBean;
import com.example.group.services.GroupActionServices;

@RestController
@RequestMapping("/groupMessageService/v1")
public class GroupActionController {
	
	@Autowired
	GroupActionServices groupActionServices;
	
	@PostMapping("/creategroup")
	public String creategroup(@RequestBody GroupDetailsBean groupDetails)
	{
		return groupActionServices.creategroup(groupDetails);
	}
	
	@PutMapping("/deleteGroup/{groupId}")
	public String deleteGroup(@PathVariable int groupId)
	{
		return groupActionServices.deleteGroup(groupId);
	}
	
	@PutMapping("/editGroupName")
	public String editGroupName(@RequestBody GroupDetailsBean groupDetails)
	{
		return groupActionServices.editGroup(groupDetails);	
	}
	
	@PutMapping("/editGroupDescription")
	public String editGroupDescription(@RequestBody GroupDetailsBean groupDetails)
	{
		return groupActionServices.editGroupDesc(groupDetails);	
	}
	
	@PutMapping("/updateGroupSettings/{groupId}/{status}/@userId")
	public String makeGroupPrivate(@PathVariable int groupId , @PathVariable int status, @PathVariable int userId)
	{
		return groupActionServices.updateGroupSettings(groupId , status , userId);
	}
	
	public String addGroupPic()
	{
		return null;
	}

}
