package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.ClassicVO;

public interface GenericDao <VO, PK>{
	
	public List<VO> selectAll();
	public VO findById(PK id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);

}
