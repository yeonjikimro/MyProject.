package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService{
	
	@Autowired
	private UserDao userDao;

	// 자동실행 하기 (꼼수)
	// BeanService 클래스로 이동
	//	@Bean
	//	public void create_table() {
	//		userDao.create_user_table();
	//		userDao.create_auth_table();
	//	}
	
	@Override
	@Bean
	public void create_user_table() {
		// TODO Auto-generated method stub
		userDao.create_user_table();
		
	}



	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	/*
	 * 회원가입 하기
	 * 1. 최초로 회원 가입 되는 username  은 ADMIN, USER 권한을 부여한다
	 * 2. 이후에 가입된 회원에게는 USER 권한을 부여한다
	 * 3. 최초로 회원 가입된 user의  enabled 칼럼을 true 로
	 * 4. 이후에 가입된 회원의 enabled 칼럼은 false 로 하여 
	 * 		이후 인증 후 사용가능 하도록 하는 기능을 추가 할수 있도록 한다
	 */
	@Override
	public int insert(UserVO vo) {
		

		return userDao.insert(vo);
		
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return userDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	@Override
	public UserVO login(UserVO userVO) {
		// TODO Auto-generated method stub
		UserVO loginUser = userDao.findById(userVO.getUsername());
		if(loginUser != null && loginUser.getPassword().equals(userVO.getPassword())) {
			return loginUser;
		}

		
		return null;
	}

}
