package com.callor.todo.service;

import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

public interface UserService extends UserDao {
	
	
	public UserVO login(UserVO userVO);

}
