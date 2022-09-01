package com.example.notesattachments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesattachments.bean.NoteBean;
import com.example.notesattachments.kafkaservices.Producer;
import com.example.notesattachments.service.NoteServices;

@RestController
@RequestMapping("/caseAnalysisService/v1/notes")
public class NoteController {

	@Autowired
	NoteServices services;
	
	@Autowired
	Producer producer;
	
	@PostMapping("/addNotes")
	public NoteBean addNotes(@RequestBody NoteBean beanRequest)
	{
		NoteBean bean= services.addNotes(beanRequest);
		producer.producerData("addNotes", "Note added for Alert Internal Id - "+bean.getAlertId()+" , Notes - "+bean.getNotes(), "addNoteAttachments");
		return bean;		
	}
	
	@GetMapping("/retriveNotes/{alertId}")
	public NoteBean retriveNotes(@PathVariable int alertId)
	{
		NoteBean bean = services.retriveNotes(alertId);
		producer.producerData("viewNotes", "Note Retrived for Alert Internal Id - "+bean.getAlertId()+" , Notes - "+bean.getNotes(), "auditkey");
		
		return bean;
	}
}
