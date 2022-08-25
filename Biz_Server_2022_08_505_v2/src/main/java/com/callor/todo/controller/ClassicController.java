package com.callor.todo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.todo.model.ClassicVO;
import com.callor.todo.service.ClassicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/classic")
public class ClassicController {

	@Autowired
	private ClassicService classicService;

	// RequestParam : name 에 있는 파라미터담아옴 만약 값이 존재하지 않을 경우 :NONE을 받아옴.)
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Principal principal,@RequestParam(name = "mood", required = false, defaultValue = "NONE") String mood, Model model) {

		// Spring Security Project 에서 로그인한 사용자의 
		// username 을 get 하기
		String username = principal.getName();
		
		log.debug("로그인한 사용자{}", username);
		// 만약 혹시, 로그인된 사용자 정보를 알수 없으면
		// 로그인 화면으로 redirect
		if(username == null) {
			
			return "redirect:/user/login?error=LOGIN_NEED";
		}

		List<ClassicVO> classicList = null;
		if(mood.equals("NONE")) {
			classicList = classicService.selectAll();
		} else {
			classicList = classicService.findByMood(mood);
		}
		log.debug("무드 {}", mood);

		model.addAttribute("CLASSIC", classicList);
				
		
		return "classic/test";
		
	}

	
	

	
	
	
}

