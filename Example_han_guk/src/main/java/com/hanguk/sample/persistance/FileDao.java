package com.hanguk.sample.persistance;

import com.hanguk.sample.model.FileVO;

public interface FileDao extends GenericDao<FileVO, String>{

	public void create_file_table();
}
