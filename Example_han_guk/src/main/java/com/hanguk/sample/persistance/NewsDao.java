package com.hanguk.sample.persistance;

import com.hanguk.sample.model.NewsVO;

public interface NewsDao extends GenericDao<NewsVO, String> {
	
	
	public void create_news_table();

}
