package com.callor.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.UserVO;
import com.callor.memo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {

		model.addAttribute("LAYOUT", "LOGIN");

		return null;		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, HttpSession session) {
		
		
		if(username == null) {
			
			return "redirect:/user/login";
		}
		session.setAttribute("USERNAME", username);

		return "redirect:/";
				
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("USERNAME");		
		return "redirect:/";
	}

}


