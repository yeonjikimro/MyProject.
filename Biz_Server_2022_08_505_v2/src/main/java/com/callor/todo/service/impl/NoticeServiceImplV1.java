package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.api.QualifierConfig;
import com.callor.todo.model.NoticeVO;
import com.callor.todo.persistance.NoticeDao;
import com.callor.todo.service.NoticeService;

@Service(QualifierConfig.SERVICE.NOTICE_V1)
public class NoticeServiceImplV1 implements NoticeService{
	
	@Autowired
	private NoticeDao noticeDao;

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
	public NoticeVO findById(String id) {
		// TODO Auto-generated method stub
		return noticeDao.findById(id);
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return noticeDao.insert(vo);
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return noticeDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return noticeDao.delete(id);
	}


}
