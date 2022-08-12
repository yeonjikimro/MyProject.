package com.callor.memo.service;

import com.callor.memo.persistance.TodoDao;

public interface TodoService extends TodoDao{

	public int com_date(String seq);
}
