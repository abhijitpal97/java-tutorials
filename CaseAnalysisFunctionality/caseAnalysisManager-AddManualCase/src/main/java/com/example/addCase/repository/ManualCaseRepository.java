package com.example.addCase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.addCase.bean.CaseItemBean;

public interface ManualCaseRepository extends JpaRepository<CaseItemBean, Integer>{
	
	@Query(value = "select ALERTIDGENERETOR.nextval from dual" , nativeQuery = true)
	public int getSeqId();
	

}
