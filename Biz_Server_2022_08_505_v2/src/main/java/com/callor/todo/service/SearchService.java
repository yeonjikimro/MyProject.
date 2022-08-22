package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.SearchVO;

public interface SearchService {

	public String queryString(String search);
	public List<SearchVO> getSearchVOs (String queryString);
	public SearchVO findById(Long PERF_NO);
	
}
