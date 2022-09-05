package com.callor.todo.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.todo.api.QualifierConfig;
import com.callor.todo.model.NoticeVO;
import com.callor.todo.persistance.NoticeDao;
import com.callor.todo.service.NoticeService;

@Service(QualifierConfig.SERVICE.NOTICE_V1)
public class NoticeServiceImplV1 implements NoticeService{
	
	@Autowired
	private NoticeDao noticeDao;
	
	public final String upLoadFolder;
	public NoticeServiceImplV1(String upLoadFolder) {
		// TODO Auto-generated constructor stub
		this.upLoadFolder = upLoadFolder;
	}

	@Bean
	public void create_notice_table() {
		noticeDao.create_notice_table();
	}

	
	@Override
	public List<NoticeVO> selectAll() {
		// TODO Auto-generated method stub
		return noticeDao.selectAll();
	}

	@Override
	public NoticeVO findById(Long id) {
		// TODO Auto-generated method stub
		return noticeDao.findById(id);
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat rdate = new SimpleDateFormat("yyyy-mm-dd");
		String dateTime = rdate.format(date);
		
		
		
		vo.setDate(dateTime);
		
		
		return noticeDao.insert(vo);
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		
		
		Date date = new Date();
		SimpleDateFormat rdate = new SimpleDateFormat("yyyy-mm-dd");
		String dateTime = rdate.format(date);
		
		vo.setDate(dateTime);
		
		return noticeDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		return noticeDao.delete(id);
	}


	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		if(file == null) {
			return null;
		}
		
		File dir = new File(upLoadFolder);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		String fileName = file.getOriginalFilename();
		
		String strUUId = UUID.randomUUID().toString();
		fileName = String.format("%s-%s", strUUId, fileName);
		File upLoaderFolder = new File(upLoadFolder, fileName);
		
		file.transferTo(upLoaderFolder);
		
		return fileName;
	}

	@Override
	public List<NoticeVO> findByUsername(String name) {
		// TODO Auto-generated method stub
		return noticeDao.findByUsername(name);
	}



}
