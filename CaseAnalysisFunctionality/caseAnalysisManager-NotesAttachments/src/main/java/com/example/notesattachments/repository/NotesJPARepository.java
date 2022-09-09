package com.example.notesattachments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesattachments.bean.NoteBean;

public interface NotesJPARepository extends JpaRepository<NoteBean, Integer>{

	List<NoteBean> findAllByalertId(int alertId);

}
