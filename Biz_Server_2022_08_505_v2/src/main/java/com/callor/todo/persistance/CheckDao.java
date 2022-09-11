package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.CheckVO;

public interface CheckDao extends GenericDao<CheckVO, String>{
	
	public void create_tbl_check();

	public List<CheckVO> findByCheck();
	
	public String putUsername(String username);
}
