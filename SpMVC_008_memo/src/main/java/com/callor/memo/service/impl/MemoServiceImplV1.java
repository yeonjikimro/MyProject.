package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService{

	protected final FileUpService fileUp;
	protected final MemoDao memoDao; 
	public MemoServiceImplV1(FileUpService fileUp, MemoDao memoDao) {
		this.fileUp = fileUp;
		this.memoDao = memoDao;
	}
	
	@Autowired
	public void create_table() {
		memoDao.create_memo_table();
	}
	
	@Override
	public List<MemoVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAndUpdate(MemoVO memo, MultipartFile file) {
		// TODO Auto-generated method stub

		long m_seq = memo.getM_seq();
		
		if(m_seq != 0) {
			
			MemoVO updateMemo = memoDao.findById(m_seq);
			
			String fileName = updateMemo.getM_image();
			
			if(!fileName.equals(file.getOriginalFilename())) {
				
				fileUp.fileDelete(updateMemo.getM_up_image());
			}
			

			String upLoadFileName = fileUp.fileUp(file);
			

			memo.setM_image(file.getOriginalFilename());
			memo.setM_up_image(upLoadFileName);
			return memoDao.update(memo);
		}
		
		memo.setM_image(file.getOriginalFilename());
		memo.setM_up_image(fileUp.fileUp(file));
		
		return memoDao.insert(memo);
	}


	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		
		MemoVO memo = memoDao.findById(seq);
		

		fileUp.fileDelete(memo.getM_up_image());
		
		memoDao.delete(seq);
		return 0;
	}

	@Override
	public MemoVO findById(Long seq) {
		// TODO Auto-generated method stub
		return memoDao.findById(seq);
	}

	@Override
	public List<MemoVO> findByAuthor(String username) {

		return memoDao.findByAuthor(username);
	}

}