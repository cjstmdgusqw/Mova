package com.chun.studyroom.member.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.member.DTO.MemberDTO;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@ModelAttribute MemberDTO memberDto){
		try {
			return new ResponseEntity<String>("회원가입 완료", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
	         return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
