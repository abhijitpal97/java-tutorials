package com.example.addCase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.addCase.bean.CaseItemBean;
import com.example.addCase.repository.ManualCaseAddRepository;
import com.example.addCase.repository.ManualCaseRepository;

@Service
public class ManualCaseService implements ManualCaseAddRepository{

	@Autowired
	ManualCaseRepository repo;

	@Autowired
	ValidatorClass validator;


	@Transactional
	@Override
	public CompletableFuture<Map<String, List<CaseItemBean>>> addManualCase(List<CaseItemBean> caseItembeans) throws Exception {
		List<CaseItemBean> successfullyAddedItem = new ArrayList<>();
		List<CaseItemBean> failedAddedItem = new ArrayList<>();
		Map<String , List<CaseItemBean>> map = new HashMap<>();
		try {
			for(CaseItemBean items : caseItembeans)
			{
				boolean isValidated = validator.isValidated(items);
				if(isValidated)
				{
					items.setAlertid("MWI_"+repo.getSeqId());
					successfullyAddedItem.add(items);
					createchildAlert(items);
					repo.save(items);
				}
				else
					failedAddedItem.add(items);
			}
			map.put("Successfully Created alertDetails" , successfullyAddedItem);
			map.put("Failed alertDetails" , failedAddedItem);
		} catch (Exception e) {
			throw new Exception();
		}
		return CompletableFuture.completedFuture(map);
	}

	private void createchildAlert(CaseItemBean items) {
		try{
			CaseItemBean casebeans = new CaseItemBean();
			casebeans.setAlertid("CHILD_"+items.getAlertid());
			casebeans.setFocustype(items.getFocustype());
			casebeans.setFocusid(items.getFocusid());
			casebeans.setFocusname(items.getFocusname());
			casebeans.setBusinessunit(items.getBusinessunit());
			casebeans.setOwnername(items.getOwnername());
			casebeans.setEscalationmarker(items.getEscalationmarker());
			repo.save(casebeans);
		}catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}


	}


}
