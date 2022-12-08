package com.example.group.interfaces;

import java.util.HashMap;
import java.util.Map;

public interface GroupMemberInterface {
	
	public String addMembersToGroup(int groupId, int userId , Map<Integer, String> map);
	public String deleteMemberFromGroup(int groupId, int userId , Map<Integer, String> map);
	public boolean isAdmin(int groupId, int userId);
	public String makeadminForGroup(int groupId, int userId, Map<Integer, String> map, int status);
	public void randomAdminSelection(int groupId);
	public String leaveGroup(int groupId, Map<Integer, String> map);

}
