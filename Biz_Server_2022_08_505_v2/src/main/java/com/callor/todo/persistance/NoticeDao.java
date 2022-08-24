package com.callor.todo.persistance;

import com.callor.todo.model.NoticeVO;

public interface NoticeDao extends GenericDao<NoticeVO, String> {
	
	public void create_notice_table();

}
