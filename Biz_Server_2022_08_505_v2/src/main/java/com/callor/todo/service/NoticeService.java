package com.callor.todo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.todo.model.NoticeVO;
import com.callor.todo.persistance.NoticeDao;

public interface NoticeService extends NoticeDao{
	
	public String fileUp(MultipartFile file) throws Exception;


}
