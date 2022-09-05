package com.hanguk.sample.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanguk.sample.model.FileVO;
import com.hanguk.sample.persistance.FileDao;

public interface FileUpService extends FileDao{
	
	// 한 개의 파일 업로드
	public String fileUp(MultipartFile file) throws Exception;
	
	public List<FileVO> multiFileUp(MultipartHttpServletRequest files) throws Exception;

}
