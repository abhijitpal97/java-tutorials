package com.example.notesattachments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesattachments.bean.NoteBean;
import com.example.notesattachments.repository.NoteRepository;
import com.example.notesattachments.repository.NotesJPARepository;

@Service
public class NoteServices implements NoteRepository{

	@Autowired
	NotesJPARepository repo;

	@Override
	public NoteBean addNotes(NoteBean beanRequest) {
		return repo.save(beanRequest);
	}
	
	@Override
	public List<NoteBean> retriveNotes(int alertId) {
		return repo.findAllByalertId(alertId);
	}


}
