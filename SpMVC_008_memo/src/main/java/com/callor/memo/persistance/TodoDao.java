package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.TodoVO;

public interface TodoDao {

	public void create_todo_table();
	public List<TodoVO> selectAll();
	public TodoVO findById(Long id);
	public int insert(TodoVO vo);
	public int update(TodoVO vo);
	public int delete(Long seq);

}
