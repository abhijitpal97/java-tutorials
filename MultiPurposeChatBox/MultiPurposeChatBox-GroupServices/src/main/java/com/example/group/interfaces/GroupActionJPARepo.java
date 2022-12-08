package com.example.group.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.group.bean.GroupDetailsBean;

public interface GroupActionJPARepo extends JpaRepository<GroupDetailsBean, Integer>{

}
