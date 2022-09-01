package com.example.notesattachments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesattachments.bean.NoteBean;

public interface NotesJPARepository extends JpaRepository<NoteBean, Integer>{

	NoteBean findAllByalertId(int alertId);

}
