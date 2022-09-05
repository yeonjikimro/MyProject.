package com.hanguk.sample.persistance;

import java.util.List;

public interface GenericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findById(Long seq);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(VO seq);
}
