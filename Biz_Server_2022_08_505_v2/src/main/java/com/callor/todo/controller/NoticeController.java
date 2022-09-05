package com.callor.todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.todo.model.NoticeVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.service.NoticeService;
import com.callor.todo.service.UserService;


@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/text")
	public String notice(NoticeVO noticeVO, Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		if(loginUser == null) {
			return "redirect:/user/login";
		}
		
		String users = loginUser.getUsername();
		
			List<NoticeVO> noticeList = noticeService.findByUsername(users);
			model.addAttribute("NOTICE", noticeList);
			
		
		return "notice/text";
	}

	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(HttpSession session, NoticeVO noticeVO) {
		
		
		
		return "notice/input";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(NoticeVO noticeVO, MultipartFile file, HttpSession session, UserVO userVO) throws Exception {
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		if(loginUser == null) {
			return "redirect:/user/login";
		}
		String users = loginUser.getUsername();
		
		noticeVO.setId(users);
		noticeService.insert(noticeVO);
		noticeService.fileUp(file);
		
		return "redirect:/notice/text";
	}
	
	@RequestMapping(value="/{seq}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model, NoticeVO noticeVO) {
		
		
		long m_seq = Long.valueOf(seq);
		noticeVO = noticeService.findById(m_seq);
		
		model.addAttribute("NOTICE", noticeVO);
		
		
		return "notice/detail";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, NoticeVO noticeVO, Model model) {
		
		long m_seq = Long.valueOf(seq);
		
		noticeVO = noticeService.findById(m_seq);
		
		model.addAttribute("NOTICE", noticeVO);
		
		return "notice/input";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, NoticeVO vo, MultipartFile file
					, HttpSession session) throws Exception {
		
		UserVO username = (UserVO) session.getAttribute("USER");
		if(username == null) {
			return "redirect:/user/login";
		}
		
		String loginUser = username.getUsername();
		
		vo.setId(loginUser);
		
		
		long m_seq = Long.valueOf(seq);
		
		vo.setSeq(m_seq);
		
		noticeService.update(vo);
		noticeService.fileUp(file);
		
		
		return "redirect:/notice/{seq}detail";
	}
	
	
	@RequestMapping(value="/{seq}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq, NoticeVO noticeVO) {
		
		
		long m_seq = Long.valueOf(seq);
		
		
		
		noticeService.delete(m_seq);
		
		
		return "redirect:/notice/text";
	}
	
	
	
	
}
