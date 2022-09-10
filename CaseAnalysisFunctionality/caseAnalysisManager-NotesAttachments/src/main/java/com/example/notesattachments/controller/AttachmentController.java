package com.example.notesattachments.controller;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.example.notesattachments.bean.AttachmentBean;
import com.example.notesattachments.bean.AttachmentReferenceBean;
import com.example.notesattachments.kafkaservices.Producer;
import com.example.notesattachments.service.AttachmentService;

@RestController
@RequestMapping("/caseAnalysisService/v1/attachments")
public class AttachmentController {

	@Autowired
	AttachmentService services;




	@Autowired Producer producer;


	@PostMapping("/addAttachments")
	public AttachmentBean uploadAttachment(@RequestParam("alertId") String alertId, @RequestParam("addedBy") String addedBy, @RequestParam("file") MultipartFile file) throws IOException
	{
		AttachmentReferenceBean referencebean = new AttachmentReferenceBean();
		AttachmentBean returnBean = new AttachmentBean();
		AttachmentReferenceBean attachmentbean =new AttachmentReferenceBean(); 

		AttachmentBean attachment = new AttachmentBean();
		attachment.setALERTID(alertId);
		attachment.setADDEDBY(addedBy);
		attachment.setATTACHMENT("Doc is stored in Mongo Db");

		if(((file.getSize()/1024)/1024)<=16)
		{
			returnBean = services.saveAttachment(attachment);

			attachmentbean = new AttachmentReferenceBean();

			attachmentbean.setAttachmentRefereceId(returnBean.getATTACHMENTINTERNALID());
			attachmentbean.setImage( new Binary(BsonBinarySubType.BINARY, file.getBytes()));

			referencebean = services.addAttachment(attachmentbean);

		}
		else
		{
			throw new MaxUploadSizeExceededException(16);
		}
		System.out.println("Attachment Added Successfully ? - " + referencebean.getId());
		producer.producerData("addAttachments", "Note added for Alert Internal Id - "+returnBean.getALERTID()+" , Attachment Documetn ID from Mongo - "+referencebean.getId(), "addNoteAttachments");
		return returnBean;
	}

	@GetMapping("/retriveAttachments/{alertId}")
	public List<AttachmentReferenceBean> retriveAttachments(@PathVariable String alertId)
	{
		List<AttachmentReferenceBean> bean =  services.retriveAttachmentInternalId(alertId);
		producer.producerData("viewAttachments", "Attachments Retrived for Alert Internal Id - "+alertId+" , Attachments Retrived - "+bean.size(), "auditkey");

		return bean;


	}
}
