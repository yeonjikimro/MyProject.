package com.callor.todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.todo.model.ClassicVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.service.ClassicService;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/classic")
public class ClassicController {

	@Autowired
	private ClassicService classicService;
	
	@Autowired
	private UserService userService;

	// RequestParam : name 에 있는 파라미터담아옴 만약 값이 존재하지 않을 경우 :NONE을 받아옴.)
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(HttpSession session, @RequestParam(name = "mood", required = false, defaultValue = "NONE") String mood, Model model, ClassicVO vo) {

		
		UserVO username = (UserVO) session.getAttribute("USER");
		
		log.debug("로그인한 사용자 {}", username);
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

