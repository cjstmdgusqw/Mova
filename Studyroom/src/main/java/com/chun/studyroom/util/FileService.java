package com.chun.studyroom.util;

import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	void fileUpload(MultipartFile file);
	void fileView(String imgName, OutputStream out);
}
