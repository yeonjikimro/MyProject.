package com.hanguk.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hanguk.sample.model.NewsVO;
import com.hanguk.sample.service.FileUpService;
import com.hanguk.sample.service.NewsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/news")
public class NewsController {
	
	@Autowired
	public NewsService newsService;
	
	@Autowired
	public FileUpService fileUpService;
	
	@RequestMapping(value="/notice", method=RequestMethod.GET)
	public String notice(Model model, NewsVO newsVO) {
		
		List<NewsVO> newsList = newsService.selectAll();
		log.debug("리스트 {}", newsList);
		
		model.addAttribute("NEWS", newsList);
		
		return "news/notice";
	}
	
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input() {
		
		
		return "news/input";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(NewsVO vo, MultipartFile file) throws Exception {
		
		log.debug("insert 내 {}", vo);
		
		
		String fileUp =  fileUpService.fileUp(file);
		vo.setImages(fileUp);
	
		
		newsService.insert(vo);
		
		return "redirect:/news/notice";
	}
	
	@RequestMapping(value="/{m_seq}/detail", method=RequestMethod.GET)
	public String detail(Model model, @PathVariable("m_seq") String seq, NewsVO vo) {
		
		long m_seq = Long.valueOf(seq);
		// --- PathVariable 사용법
		
		vo = newsService.findById(m_seq);
		model.addAttribute("news", vo);

		
		return "news/detail";
	}

}
