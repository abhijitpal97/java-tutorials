package com.example.group.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.group.services.GroupMemberServices;

@RestController
@RequestMapping("/groupMessageService/v1")
public class GroupMemberController {
	
	@Autowired
	GroupMemberServices memberServices;
	
	@PostMapping("/addMembersToGroup/{groupId}/{userId}")
	public String addMemberToGroup(@PathVariable int groupId, @PathVariable int userId , @RequestBody Map<Integer, String> map)
	{
		return memberServices.addMembersToGroup(groupId , userId , map);
	}
	
	@PostMapping("/deleteMemberFromGroup/{groupId}/{userId}")
	public String deleteMemberFromGroup(@PathVariable int groupId , @PathVariable int userId , @RequestBody Map<Integer, String> map)
	{
		return memberServices.deleteMemberFromGroup(groupId , userId , map);
	}
	
	@PutMapping("/makeadminForGroup/{groupId}/{userId}")
	public String makeadminForGroup(@PathVariable int groupId , @PathVariable int userId , @RequestBody Map<Integer, String> map)
	{
		return memberServices.makeadminForGroup(groupId , userId , map , 1);
	}
	
	@PutMapping("/removeAdminFromGroup/{groupId}/{userId}")
	public String removeAdminFromGroup(@PathVariable int groupId , @PathVariable int userId , @RequestBody Map<Integer, String> map)
	{
		return memberServices.makeadminForGroup(groupId , userId , map , 0);
	}
	
	@PostMapping("leaveGroup/{groupId}/{userId}")
	public String leaveGroup(@PathVariable int groupId , @PathVariable int userId)
	{
		Map<Integer, String> map = new HashMap<>();
		map.put(userId, "PRESET");
		String deleteresult = memberServices.leaveGroup(groupId, map);
		if(deleteresult.contains("User Successfully left"))
		{
			memberServices.randomAdminSelection(groupId);
		}
		
		return deleteresult;
	}
	
}
