package com.callor.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.callor.todo.model.NoticeVO;
import com.callor.todo.service.NoticeService;


@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/text")
	public String notice(NoticeVO noticeVO, Model model) {
		
		List<NoticeVO> noticeList = noticeService.selectAll();
		model.addAttribute("NOTICE", noticeList);
		
		return "notice/text";
	}

}
