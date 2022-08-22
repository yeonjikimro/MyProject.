package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	
	@RequestMapping(value="/")
	public String notice() {
		
		return "notice/home";
	}

}
