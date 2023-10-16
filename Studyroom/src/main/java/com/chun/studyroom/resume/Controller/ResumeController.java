package com.chun.studyroom.resume.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.resume.DTO.ResumeDTO;
import com.chun.studyroom.resume.Entity.Resume;
import com.chun.studyroom.resume.Service.ResumeService;

@RestController
@RequestMapping("resume")
public class ResumeController {
	
	@Autowired
	private ResumeService resumeservice;
	
	@PostMapping("/writeResume")
	public ResponseEntity<String> writeresume(@ModelAttribute ResumeDTO resumedto) {
		try {
			resumeservice.writeResume(resumedto);
			System.out.println(resumedto.getTitle());
			return new ResponseEntity<String> ("이력서 작성 완료", HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/selectResume")
	public ResponseEntity<List<ResumeDTO>> selectResume(String memberid){
		try {
			return new ResponseEntity<List<ResumeDTO>>(resumeservice.selectResume(memberid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ResumeDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/detailResume")
	public ResponseEntity<ResumeDTO> detailResume(Long resumeid){
		try {
			return new ResponseEntity<ResumeDTO> (resumeservice.detailResume(resumeid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResumeDTO> (HttpStatus.BAD_REQUEST);
		}
	}
}
