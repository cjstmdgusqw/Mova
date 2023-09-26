package com.chun.studyroom.member.Controller;

import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@ModelAttribute MemberDTO memberDto){
		try {
			memberservice.insertmember(memberDto);
			return new ResponseEntity<String>("회원가입 완료", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
	         return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody Map<String, String> param){
		try {
			memberservice.selectmember(param.get("id"), param.get("password"));
			return new ResponseEntity<String>("로그인 되었습니다", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/selectmemberID")
	public ResponseEntity<Long> select(@RequestParam("id") String id){
		try {
			return new ResponseEntity<Long>(memberservice.memberid(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/apply")
	public ResponseEntity<String> applyMember(@RequestBody Map<String, Long> param){
		try {
			memberservice.applyteam(param.get("id"), param.get("roomid"));
			return new ResponseEntity<String>("신청이 완료되었습니다", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
