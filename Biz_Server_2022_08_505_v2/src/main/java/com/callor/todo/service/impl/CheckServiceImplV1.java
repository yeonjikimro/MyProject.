package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.CheckVO;
import com.callor.todo.persistance.CheckDao;
import com.callor.todo.service.CheckService;
import com.callor.todo.service.ClassicService;

@Service
public class CheckServiceImplV1 implements CheckService{
	
	@Override
	@Bean
	public void create_tbl_check() {
		// TODO Auto-generated method stub
		
		checkDao.create_tbl_check();
		
	}

	
	@Autowired
	private CheckDao checkDao;

	@Override
	public List<CheckVO> selectAll() {
		// TODO Auto-generated method stub
		return checkDao.selectAll();
	}

	@Override
	public CheckVO findById(String id) {
		// TODO Auto-generated method stub
		return checkDao.findById(id);
	}

	@Override
	public int insert(CheckVO vo) {
		// TODO Auto-generated method stub
		

		return checkDao.insert(vo);
	}

	@Override
	public int update(CheckVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CheckVO> findByCheck() {
		// TODO Auto-generated method stub
		
		
		return checkDao.findByCheck();
	}

	@Override
	public String putUsername(String username) {
		// TODO Auto-generated method stub
		return checkDao.putUsername(username);
	}



}
