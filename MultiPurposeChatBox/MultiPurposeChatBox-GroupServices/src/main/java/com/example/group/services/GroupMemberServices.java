package com.example.group.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.group.bean.GroupUserBean;
import com.example.group.interfaces.GroupMemberInterface;
import com.example.group.interfaces.GroupUserJPARepo;


@Service
public class GroupMemberServices implements GroupMemberInterface{


	@Autowired
	GroupUserJPARepo usergrouprepo;

	@Override
	public String addMembersToGroup(int groupId, int userId, Map<Integer, String> map) {
		if(isAdmin(groupId, userId))
		{
			CopyOnWriteArrayList<Integer> successlist = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Integer> failurelist = new CopyOnWriteArrayList<>();
			map.forEach(
					(k,v) ->
					{
						GroupUserBean entity = new GroupUserBean();
						entity.setGroupId(groupId);
						entity.setUserId(k);
						try
						{
							entity = usergrouprepo.save(entity);
							successlist.add(entity.getUserId());
						}
						catch(Exception e)
						{
							failurelist.add(k);
						}

					}
					);	
			return "User Successfully added - "+successlist+" and failed user List - "+failurelist;	

		}
		else
		{
			return "You are not authorized to Add any Members";
		}

	}

	@Override
	public String deleteMemberFromGroup(int groupId, int userId , Map<Integer, String> map) {
		if(isAdmin(groupId, userId))
		{
			CopyOnWriteArrayList<Integer> successlist = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Integer> failurelist = new CopyOnWriteArrayList<>();
			map.forEach(
					(k,v) ->
					{
						List<GroupUserBean> entities = usergrouprepo.findByGroupIdAndUserId(groupId, k);
						try
						{
							entities.forEach(
									(entity) -> {
										usergrouprepo.delete(entity);
										successlist.add(k);
									}
									);

						}
						catch(Exception e)
						{
							failurelist.add(k);
						}

					}
					);	
			return "User Successfully removed - "+successlist+" adn failed user List - "+failurelist;	

		}
		else
		{
			return "You are not authorized to Delete any Members";
		}
	}

	@Override
	public boolean isAdmin(int groupId, int userId)
	{
		List<GroupUserBean> groupuserbean = usergrouprepo.findByGroupIdAndUserIdAndIsadmin(groupId, userId , 1);
		List<Integer> allowedUser = new ArrayList<>();
		groupuserbean.forEach(
				u -> allowedUser.add(u.getUserId())
				);

		if(allowedUser.contains(userId))
			return true;
		else return false;
	}

	@Override
	public String makeadminForGroup(int groupId, int userId, Map<Integer, String> map, int status) {
		if(isAdmin(groupId, userId))
		{
			map.forEach(
					(k , v) ->
					{
						List<GroupUserBean> entities = usergrouprepo.findByGroupIdAndUserId(groupId, k);
						entities.forEach(
								entity -> 
								{
									entity.setIsadmin(status);
									usergrouprepo.save(entity);
								}
								);

					}
					);
			return status==1?"Successfully Role Changed as Admin":"Successfully Role Revoked as Admin";
		}
		else
		{
			return "You are not authorized to Choose Admin";
		}
	}

	@Override
	public void randomAdminSelection(int groupId) {
		List<GroupUserBean> adminCounts = usergrouprepo.findByGroupIdAndIsadmin(groupId, 1);
		if(adminCounts.isEmpty())
		{
			List<GroupUserBean> entities = usergrouprepo.findByGroupId(groupId);

			GroupUserBean bean = entities.get(0);
			bean.setIsadmin(1);
			usergrouprepo.save(bean);
		}
	}

	@Override
	public String leaveGroup(int groupId, Map<Integer, String> map) {
		CopyOnWriteArrayList<Integer> successlist = new CopyOnWriteArrayList<>();
		CopyOnWriteArrayList<Integer> failurelist = new CopyOnWriteArrayList<>();
		map.forEach(
				(k,v) ->
				{
					List<GroupUserBean> entities = usergrouprepo.findByGroupIdAndUserId(groupId, k);
					try
					{
						entities.forEach(
								(entity) -> {
									usergrouprepo.delete(entity);
									successlist.add(k);
								}
								);

					}
					catch(Exception e)
					{
						failurelist.add(k);
					}

				}
				);	
		return "User Successfully left - "+successlist+" and  failed user List - "+failurelist;	


	}
}
