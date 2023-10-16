package com.chun.studyroom.resume.Service;

import java.util.List;

import com.chun.studyroom.resume.DTO.ResumeDTO;

public interface ResumeService {
	void writeResume(ResumeDTO resume) throws Exception;
	List<ResumeDTO> selectResume(String memberid) throws Exception;
	ResumeDTO detailResume(Long resumeid) throws Exception;
}
