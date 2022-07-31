package com.example.addCase.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.example.addCase.bean.CaseItemBean;


public interface ManualCaseAddRepository {
	
	CompletableFuture<Map<String, List<CaseItemBean>>> addManualCase(List<CaseItemBean> config) throws Exception;

}
