package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.NoticeVO;
import com.callor.todo.model.UserVO;

public interface NoticeDao extends GenericDao<NoticeVO, Long> {
	
	public void create_notice_table();
	public List<NoticeVO> findByUsername(String name);
	


}
