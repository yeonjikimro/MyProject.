package com.callor.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String music(Model model,
			@RequestParam(name = "pageno", required = false, defaultValue="1") int pageno) {
		
//		searchPage.setCurrentPageNo(pageno);
//		
//		// 페이지 계산
//		searchService.getSearchVOs(encodeParams);
//		log.debug("페이지 계산 {}", searchPage.toString());
//		
//		// 데이터 가져오기
//		List<SearchVO> dataList = searchService.getSearchVOs(encodeParams);
//		model.addAttribute("PAGE", dataList);
//		
//		
		String queryString = searchService.queryString(pageno);
		
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

	@RequestMapping(value="/{PERF_NO}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("PERF_NO") String queryString,  Model model, SearchVO searchVO) {
		
		
		List<SearchVO> detailList = searchService.getSearchVOs(queryString);
		
		for(SearchVO vo : detailList) {
			
			model.addAttribute("DETAIL", vo);	
			
		}
		
		
		
		return "music/detail";
	}
}
