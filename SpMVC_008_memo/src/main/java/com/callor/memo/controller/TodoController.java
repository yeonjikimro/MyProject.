package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.memo.model.TodoVO;
import com.callor.memo.model.UserVO;
import com.callor.memo.service.TodoService;
import com.callor.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/schedule")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String todo(@ModelAttribute("todoVO") TodoVO tovoVO, Model model, HttpSession session) {
		
		
		String userVO = (String) session.getAttribute("USERNAME");
		if(userVO == null) {
			return "redirect:/user/login";
		}

		
		List<TodoVO> todomenu = todoService.selectAll();
		
		
		List<TodoVO> schemenu = todoService.selectAll();
		
		
		model.addAttribute("TODOMENU", todomenu);
		model.addAttribute("SCHMENU", schemenu);
		log.debug(todomenu.toString());
		log.debug(schemenu.toString());
		
		return "schedule/todo";
	}
	
	
	
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public String todo(Model model, TodoVO todoVO, HttpSession session) {
		
		String userVO = (String) session.getAttribute("USERNAME");
		if(userVO == null) {
			return "redirect:/user/login";
		}
		todoVO.setT_username(userVO);
		todoService.insert(todoVO);
		
		return "redirect:/schedule/todo";
	}
	
	
	@RequestMapping(value="/{t_seq}/complete", method=RequestMethod.GET)
	public String complete (@PathVariable("t_seq") String t_seq, Model model, TodoVO todoVO) {


		todoService.com_date(t_seq);
	
		return "redirect:/schedule/todo";
	}
	
	@RequestMapping(value="/{t_seq}/update", method=RequestMethod.GET)
	public String update (@PathVariable("t_seq") String t_seq, Model model) {
		
		long seq = Long.valueOf(t_seq);
		// 경로
		TodoVO todoVO = todoService.findById(seq);
		model.addAttribute("TODO", todoVO);

	
	
		return "schedule/todo";
	}
	
	@RequestMapping(value="/{t_seq}/update", method=RequestMethod.POST)
	public String update (@PathVariable("t_seq") String t_seq, @ModelAttribute("TODO") TodoVO todoVO) {
		
		todoService.update(todoVO);
		
		return "redirect:/schedule/todo";
	}

}
