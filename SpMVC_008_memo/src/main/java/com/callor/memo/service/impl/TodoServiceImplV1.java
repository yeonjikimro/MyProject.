package com.callor.memo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.memo.model.TodoVO;
import com.callor.memo.persistance.TodoDao;
import com.callor.memo.persistance.UserDao;
import com.callor.memo.service.TodoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class TodoServiceImplV1 implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private UserDao userDao;
	
	@Bean
	public void create_todo_table() {
		// TODO Auto-generated method stub
		todoDao.create_todo_table();
		
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}


	@Override
	public int insert(TodoVO vo) {
		// TODO Auto-generated method stub

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat timeForm = new SimpleDateFormat("HH:mm:ss");
		vo.setP_date(dateForm.format(date));
		vo.setP_time(timeForm.format(date));
		
	
		
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		// TODO Auto-generated method stub
		return todoDao.update(vo);
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return todoDao.delete(seq);
	}

	@Override
	public TodoVO findById(Long id) {
		// TODO Auto-generated method stub
		return todoDao.findById(id);
	}

	@Override
	public int com_date(String seq) {
		// TODO Auto-generated method stub

		long m_seq = 0L;
		try {
			m_seq = Long.valueOf(seq);
			
		} catch (Exception e) {
			return -1;
		}
		
		TodoVO todoVO = todoDao.findById(m_seq);
	
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat timeForm = new SimpleDateFormat("HH:mm:ss");
		todoVO.setC_date(dateForm.format(date));
		todoVO.setC_time(timeForm.format(date));

		
		todoVO.setComplete(true);
		if(!todoVO.getComplete()) {
			todoVO.setC_date("");
			todoVO.setC_time("");
		}
		log.debug("ihuhu {}",todoVO);

		
		
		return todoDao.update(todoVO);
	}



}
