package com.example.group.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.group.bean.GroupUserBean;

@Repository
public interface GroupUserJPARepo extends JpaRepository<GroupUserBean, Integer>{

	List<GroupUserBean> findByUserId(int userId);
	List<GroupUserBean> findByGroupIdAndUserIdAndIsadmin(int groupId , int userId , int isadmin);
	List<GroupUserBean> findByGroupIdAndUserId(int groupId , int userId);
	List<GroupUserBean> findByGroupId(int groupId);
	List<GroupUserBean> findByGroupIdAndIsadmin(int groupId, int isadmin);

}
