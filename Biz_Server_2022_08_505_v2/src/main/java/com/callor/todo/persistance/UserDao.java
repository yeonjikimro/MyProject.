package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {

	public void create_user_table();
	
	public List<UserVO> selectAll();
	public UserVO findById(String id);
	public int update(UserVO userVO);
	public int insert(UserVO userVO);
	public int delete(String id);
	
}
