package com.hanguk.sample.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanguk.sample.model.FileVO;
import com.hanguk.sample.persistance.FileDao;
import com.hanguk.sample.service.FileUpService;

@Service
public class FileUpServiceImplV1 implements FileUpService{
	
	private final String upLoadFolder;
	public FileUpServiceImplV1(String upLoadFolder) {
		// TODO Auto-generated constructor stub
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		if(file == null ) {
			return null;
		}
	
		File dir = new File(upLoadFolder);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		String fileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		fileName = String.format("%s-%s", strUUID, fileName);
		
		File uploadFolder = new File(upLoadFolder, fileName);
		
		file.transferTo(uploadFolder);
		
		return fileName;
	}

	@Override
	public List<FileVO> multiFileUp(MultipartHttpServletRequest files) throws Exception {
		
		List<MultipartFile> fileList = files.getFiles(upLoadFolder);
		
		List<FileVO> finalFileList = new ArrayList<FileVO>();
		
		
		for(MultipartFile file : fileList ) {
			
			String originalName = file.getOriginalFilename();
			String uuid = this.fileUp(file);
			
			FileVO fileVO = FileVO.builder()
					.originName(originalName)
					.writeName(uuid)
					.build();
			
			finalFileList.add(fileVO);
		}
		
		// TODO Auto-generated method stub
		return finalFileList;
	}
	
	@Autowired
	public FileDao fileDao;

	@Override
	public List<FileVO> selectAll() {
		// TODO Auto-generated method stub
		return fileDao.selectAll();
	}

	@Override
	public FileVO findById(Long seq) {
		// TODO Auto-generated method stub
		return fileDao.findById(seq);
	}

	@Override
	public int insert(FileVO vo) {
		// TODO Auto-generated method stub
		return fileDao.insert(vo);
	}

	@Override
	public int update(FileVO vo) {
		// TODO Auto-generated method stub
		return fileDao.update(vo);
	}

	@Override
	public int delete(FileVO seq) {
		// TODO Auto-generated method stub
		return fileDao.delete(seq);
	}

	@Override
	public void create_file_table() {
		// TODO Auto-generated method stub
		
		fileDao.create_file_table();
		
	}


}
