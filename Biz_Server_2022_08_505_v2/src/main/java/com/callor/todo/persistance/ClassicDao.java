package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.ClassicVO;

public interface ClassicDao extends GenericDao<ClassicVO, String>{
	
	public List<ClassicVO> findByMood(String mood);
	public List<ClassicVO> findByCheck(ClassicVO vo);
	public List<ClassicVO> findBySong(String username);

}
