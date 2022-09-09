package com.example.notesattachments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesattachments.bean.AttachmentBean;
import com.example.notesattachments.bean.AttachmentReferenceBean;
import com.example.notesattachments.repository.AttachmentJPARepository;
import com.example.notesattachments.repository.AttachmentMongoRepository;
import com.example.notesattachments.repository.AttachmentRepository;

@Service
public class AttachmentService implements AttachmentRepository{

	@Autowired
	AttachmentJPARepository repo;
	
	@Autowired
	AttachmentMongoRepository mongoRepo;

	@Override
	public AttachmentBean saveAttachment(AttachmentBean attachment) {

		return repo.save(attachment);
	}

	@Override
	public AttachmentReferenceBean addAttachment(AttachmentReferenceBean attachment) {
		
		return mongoRepo.save(attachment);
	}

	@Override
	public List<AttachmentReferenceBean> retriveAttachmentInternalId(String alertId) {
		
		List<AttachmentBean> bean = repo.findAllByALERTID(alertId);
		List<Integer> ids = new ArrayList<>();
		bean.stream().forEach( 
				(t) -> ids.add(t.getATTACHMENTINTERNALID())
				);
		
		return mongoRepo.findAllByattachmentRefereceIdIn(ids);
	}
}
