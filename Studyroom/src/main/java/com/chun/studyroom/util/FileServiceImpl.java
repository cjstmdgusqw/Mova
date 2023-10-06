package com.chun.studyroom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileService {
	private String dir = "C:/resources/uload";


	@Override
	public void fileUpload(MultipartFile file) {
		 try {
	            if (file != null && !file.isEmpty()) {
	                String fileName = file.getOriginalFilename();
	                File dfile = new File(dir + fileName);
	                // 디렉토리가 없는 경우 디렉토리 생성
	                if(!dfile.getParentFile().exists()) {
	                    dfile.getParentFile().mkdirs();
	                }
	                file.transferTo(dfile);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("여기맞아요?"+dir);
	        }

	}

	@Override
	public void fileView(String imgName, OutputStream out) {
        try{
            FileInputStream fis = new FileInputStream(dir + imgName);
            FileCopyUtils.copy(fis, out);
            out.flush();  
        }catch(Exception e) {
            e.printStackTrace();
        }
	}	
}
