package com.example.notesattachments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesattachments.bean.AttachmentBean;

public interface AttachmentJPARepository extends JpaRepository<AttachmentBean, Integer>{

	List<AttachmentBean> findAllByALERTID(String alertId);
	
}
