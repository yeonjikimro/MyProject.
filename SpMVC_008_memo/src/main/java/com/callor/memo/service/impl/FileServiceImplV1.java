package com.callor.memo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.service.FileUpService;

@Service
public class FileServiceImplV1 implements FileUpService {

	/*
	 * servlet-context.xml �� �����  ���ڿ� ���� �� �����ϱ�
	 */
	@Autowired
	protected String upLoadFolder;
	
	
	@Override
	public String fileUp(MultipartFile file) {

		// ���� ������ ������ ���̻� �������� ����
		if(file == null) {
			return null;
		}
		
		// ������ ���� Ȯ���ϱ�
		// java.io.File import
		File dir = new File(upLoadFolder);
		// ���ε��� ������ ������
		if( dir.exists() == false) {
			// ������ ������
			dir.mkdirs();
		}
		
		// ���ε�� ������ �̸� getter
		String originFileName = file.getOriginalFilename();
		
		// ��ŷ�� �����ϱ� ���Ͽ� ���� �̸� �����ϱ�
		// 1. UUID ���ڿ� ����
		String uuStr = UUID.randomUUID().toString();
		
		// ���� ���� �̸��� UUID �� �ռ��Ͽ� ���ο� ���� �̸� �����ϱ�
		String saveFileName = String.format("%s-%s", uuStr, originFileName);
		
		// ������ �����ϱ� ���� ���� ��ü ����
		File saveFile = new File(upLoadFolder, saveFileName);
		
		try {
			file.transferTo(saveFile);
			return saveFileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fileDelete(String fileName) {
		
		if(fileName == null) {
			return;
		}
		
		// ���ε� ������ ���� �̸��� ���� ���� ��ü ����
		File deleteFile = new File(upLoadFolder, fileName);
		
		// ���� ������ �����ϴ��� Ȯ���ϰ�
		if(deleteFile.exists()) {
			// �����ϸ� ������ ����
			deleteFile.delete();
		}
		
	}

	
	
}