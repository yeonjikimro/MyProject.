package com.callor.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.CheckVO;
import com.callor.todo.model.ClassicVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.service.CheckService;
import com.callor.todo.service.ClassicService;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClassicService classicService;
	
	@Autowired
	private CheckService checkService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT","JOIN");
		return "home";
	}


	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원가입 정보 {}", userVO);
		userService.insert(userVO);
		return "redirect:/";
		
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String error, Model model, HttpSession session) {

		model.addAttribute("error", error);
		model.addAttribute("LAYOUT", "LOGIN");

		
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserVO userVO, Model model, HttpSession session) {
		UserVO loginUser = userService.findById(userVO.getUsername());
		if(loginUser == null) {
			model.addAttribute("error", "USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(userVO);
		if(loginUser == null) {
			model.addAttribute("error", "PASSWORD_FAIL");
			return "redirect:/user/login";
		}
		
		session.setAttribute("USER", loginUser);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
	
		session.removeAttribute("USER");
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/{username}/mypage", method=RequestMethod.GET)
	public String mypage(@PathVariable("username") String username, UserVO userVO, Model model, HttpSession session, CheckVO checkVO) {
		
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		
		if(loginUser == null) {
			model.addAttribute("error", "LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		
		model.addAttribute("user", loginUser);
		
		
		checkVO.setUsername(loginUser.getUsername());
		checkService.insert(checkVO);

		
		
		List<CheckVO> checkList = new ArrayList<CheckVO>();

		
		checkList = checkService.findByCheck();
		
		
		// username이 너무 많아서(노래 리스트마다 등록)반환이 안되
		
		if(loginUser.getUsername().equals(checkVO.getUsername())) {
		
			model.addAttribute("cht", checkList);
			
		}
			
		
		
//		
//		if(vo.getCheckbox() == 1) {
//			checkList.add(check);
//		}

		log.debug("체크리스트 {} ", checkList);



		return "user/mypage";
	}

	
	
	@RequestMapping(value="/{username}/mypage", method=RequestMethod.POST)
	public String checkbox(String check, CheckVO checkVO) {
		
		ClassicVO cvo = classicService.findBySseq(check);
		
		log.debug("업데이트 전 : {}", cvo);
		cvo.setCheckbox(1);
		classicService.update(cvo);
		log.debug("set 이후 : {}", cvo);
	
		
		checkVO.setSong(cvo.getSong());
		checkVO.setMusician(cvo.getMusician());
		checkVO.setCheckbox(cvo.getCheckbox());
		checkService.insert(checkVO);
		
		return "redirect:/classic/test";
	}
	
	
	
	@RequestMapping(value="/test")
	public String test(Model model, HttpSession session, UserVO userVO) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		
		if(loginUser == null) {
			model.addAttribute("error", "LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		model.addAttribute("NAME", loginUser);

		model.addAttribute("LAYOUT", "TEST");
		
		return "user/mypage";
	}

}
