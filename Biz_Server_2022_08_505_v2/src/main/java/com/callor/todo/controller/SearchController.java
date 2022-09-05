package com.callor.todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.todo.model.SearchVO;
import com.callor.todo.model.UserVO;
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
			@RequestParam(name = "pageno", required = false, defaultValue="1") int pageno, HttpSession session) {
		
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
		UserVO username = (UserVO) session.getAttribute("USER");
		if(username == null) {
			
			return "redirect:/user/login?error=LOGIN_NEED";
		}
		
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
	public String detail(@PathVariable("PERF_NO") String seq,  Model model, SearchVO searchVO) {
		
		log.debug("glglglg {}", seq);
		
		List<SearchVO> selectList = searchService.getSearchVOs(searchService.queryString(null));
		SearchVO detail = null;
		
		
		 long long_seq = Long.valueOf(seq);
		for(SearchVO vo : selectList) {
			if(vo.getPERF_NO() == long_seq) {
				detail = vo;
			}
		}
		
		model.addAttribute("DETAIL",detail);
		
		
		return "music/detail";
	}
}
