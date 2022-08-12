package com.callor.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.FaqVO;


@Controller
@RequestMapping(value="/qna")
public class FaqController {


	@RequestMapping(value="/faq", method=RequestMethod.GET)
	public String faq(Model model, FaqVO faqVO, HttpSession session) {
		

		
		return "qna/faq";
	}


}
