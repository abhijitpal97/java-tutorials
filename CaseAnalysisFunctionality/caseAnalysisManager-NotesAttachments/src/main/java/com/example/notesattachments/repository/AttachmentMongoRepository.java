package com.example.notesattachments.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.notesattachments.bean.AttachmentReferenceBean;

public interface AttachmentMongoRepository extends MongoRepository<AttachmentReferenceBean, Integer>{

	List<AttachmentReferenceBean> findAllByattachmentRefereceIdIn(List<Integer> ids);

}
