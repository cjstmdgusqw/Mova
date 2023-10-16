package com.chun.studyroom.resume.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.member.Repository.MemberRespository;
import com.chun.studyroom.resume.DTO.ResumeDTO;
import com.chun.studyroom.resume.Entity.Resume;
import com.chun.studyroom.resume.Respository.ResumeRespository;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
	private ResumeRespository resumerespository;
	
	@Autowired
	private MemberRespository memberrespository;

	@Override
	public void writeResume(ResumeDTO resume) throws Exception {
		Resume resumes = new Resume();
		resumes.setAge(resume.getAge());
		resumes.setContent(resume.getContent());
		resumes.setMember(memberrespository.selectMember2(resume.getMemberid()));
		resumes.setPhoneumber(resume.getPhonenumber());
		resumes.setTitle(resume.getTitle());
		resumerespository.save(resumes);
	}

	@Override
	public List<ResumeDTO> selectResume(String memberid) throws Exception {
		Long Id = memberrespository.selectmemberId(memberid);
		List<Resume> resume = resumerespository.selectResume(Id);
		List<ResumeDTO> resumes = new ArrayList<ResumeDTO>();
		for (Resume resume2 : resume) {
			ResumeDTO resmedto = new ResumeDTO();
			resmedto.setAge(resume2.getAge());
			resmedto.setContent(resume2.getContent());
			resmedto.setTitle(memberid);
			resmedto.setResumeId(resume2.getResumeid());
			resumes.add(resmedto);
		}
		return resumes;
	}

	@Override
	public ResumeDTO detailResume(Long resumeid) throws Exception {
		Resume resume = resumerespository.findById(resumeid).get();
		ResumeDTO resumedto = new ResumeDTO();
		resumedto.setAge(resume.getAge());
		resumedto.setContent(resume.getContent());
		resumedto.setPhonenumber(resume.getPhoneumber());
		resumedto.setTitle(resume.getTitle());
		resumedto.setMember(resume.getMember());
		return resumedto;
	}	
	
}
