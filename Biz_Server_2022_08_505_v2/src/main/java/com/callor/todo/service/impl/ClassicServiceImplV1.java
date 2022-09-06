package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.ClassicVO;
import com.callor.todo.persistance.ClassicDao;
import com.callor.todo.service.ClassicService;

@Service
public class ClassicServiceImplV1 implements ClassicService{

	@Autowired
	private ClassicDao classicDao;



	@Override
	public List<ClassicVO> selectAll() {
		// TODO Auto-generated method stub
		return classicDao.selectAll();
	}

	@Override
	public ClassicVO findById(String id) {
		// TODO Auto-generated method stub
		return classicDao.findById(id);
	}

	@Override
	public int insert(ClassicVO vo) {
		// TODO Auto-generated method stub
		return classicDao.insert(vo);
	}

	@Override
	public int update(ClassicVO vo) {
		// TODO Auto-generated method stub
			
		
		vo.setCheckbox(1);

		return classicDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ClassicVO> findByMood(String mood) {
		// TODO Auto-generated method stub
		return classicDao.findByMood(mood);
	}




	@Override
	public ClassicVO findByCheck(ClassicVO vo) {
		// TODO Auto-generated method stub
		return classicDao.findByCheck(vo);
	}

	@Override
	public ClassicVO findBySseq(String seq) {
		// TODO Auto-generated method stub
		return classicDao.findBySseq(seq);
	}

	


}
