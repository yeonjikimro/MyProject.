package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.memo.model.TodoVO;
import com.callor.memo.model.UserVO;
import com.callor.memo.persistance.TodoDao;
import com.callor.memo.persistance.UserDao;
import com.callor.memo.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TodoDao todoDao;
	
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		
		List<UserVO> userList = userDao.selectAll();
		List<TodoVO> todoList = todoDao.selectAll();
		
		if(userList == null) {
			
			todoList.add(TodoVO.builder()
					.t_username(vo.getId())
					.build()
					);
		}
		
		
		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Bean
	public void create_user_table() {
		// TODO Auto-generated method stub
		
		userDao.create_user_table();
	}

}
