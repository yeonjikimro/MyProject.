package com.hanguk.sample.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.hanguk.sample.model.NewsVO;
import com.hanguk.sample.persistance.FileDao;
import com.hanguk.sample.persistance.NewsDao;
import com.hanguk.sample.service.NewsService;

@Controller
@Service
public class NewsServiceImplV1 implements NewsService{
		

	public NewsDao newsDao;
	public NewsServiceImplV1(NewsDao newsDao) {
		// TODO Auto-generated constructor stub
		this.newsDao = newsDao;
	}

	@Autowired
	public void create_news_table() {
		// TODO Auto-generated method stub
		newsDao.create_news_table();
	}
	
	
	@Override
	public List<NewsVO> selectAll() {
		// TODO Auto-generated method stub
		return newsDao.selectAll();
	}


	@Override
	public NewsVO findById(Long seq) {
		// TODO Auto-generated method stub
		return newsDao.findById(seq);
	}



	@Override
	public int insert(NewsVO vo) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd");
		String writeDay = dateTime.format(date);
		
		
		vo.setDate(writeDay);
		
		return newsDao.insert(vo);
	}


	@Override
	public int update(NewsVO vo) {
		// TODO Auto-generated method stub
		return newsDao.update(vo);
	}




	@Override
	public int delete(NewsVO seq) {
		// TODO Auto-generated method stub
		return newsDao.delete(seq);
	}


}
