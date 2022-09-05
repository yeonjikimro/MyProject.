package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.ClassicVO;

public interface ClassicDao extends GenericDao<ClassicVO, String>{
	
	public List<ClassicVO> findByMood(String mood);
	public ClassicVO findByUsername(String username);
	public ClassicVO findByCheck(ClassicVO vo);
	public ClassicVO findBySseq(String seq);
}
