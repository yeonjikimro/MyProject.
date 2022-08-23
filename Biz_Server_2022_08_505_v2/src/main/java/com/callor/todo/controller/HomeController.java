package com.callor.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.SearchVO;
import com.callor.todo.service.SearchService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	public SearchService searchService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, SearchVO searchVO) {
		
		
		String queryString = searchService.queryString(null);
		
		List<SearchVO> searchList = searchService.getSearchVOs(queryString);
		
		model.addAttribute("SEARCH", searchList);
	
		
		return "home";
	}

	
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String error403() {
		return "error/403";
	}
	
	
}
