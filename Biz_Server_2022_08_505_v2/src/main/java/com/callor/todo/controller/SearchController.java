package com.callor.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.todo.model.SearchVO;
import com.callor.todo.service.SearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/music")
public class SearchController {
	
	private final SearchService searchService;
	

	public SearchController(SearchService searchService) {
		this.searchService = searchService;
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String music(Model model, SearchVO searchVO) {
		
		String queryString = searchService.queryString(null);
		
		List<SearchVO> searchList = searchService.getSearchVOs(queryString);
		model.addAttribute("SEARCH", searchList);
		
		return "music/search";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/json", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<SearchVO> json() {
		String queryString = searchService.queryString(null);
		List<SearchVO> search = searchService.getSearchVOs(queryString);
		
		return search;
	}

	@RequestMapping(value="/{seq}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String PERF_NO,  Model model, SearchVO searchVO) {
		
		long m_seq = Long.valueOf(PERF_NO);
		searchVO = searchService.findById(m_seq);
		
		model.addAttribute("SEARCH", searchVO);
		
		
		return "music/detail";
	}
}
