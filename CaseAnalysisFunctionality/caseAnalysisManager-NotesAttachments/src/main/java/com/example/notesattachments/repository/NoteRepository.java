package com.example.notesattachments.repository;

import java.util.List;

import com.example.notesattachments.bean.NoteBean;

public interface NoteRepository {
	NoteBean addNotes(NoteBean beanRequest);
	List<NoteBean> retriveNotes(int alertId);

}
