package com.chun.studyroom.member.Controller;

import java.util.Map;

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
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
//	회원가입
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
//	로그인
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
	
//	memberid조회
	@GetMapping("/selectmemberID")
	public ResponseEntity<Long> select(@RequestParam("id") String id){
		try {
			return new ResponseEntity<Long>(memberservice.memberid(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	방 신청 
	@PostMapping("/apply")
	public ResponseEntity<String> applyMember(@RequestBody Map<String, Long> param){
		try {
			if(memberservice.check(param.get("id"), param.get("roomid")) != null){
				return new ResponseEntity<String>("이미 신청하셨습니다", HttpStatus.OK);
			}
			memberservice.applyteam(param.get("id"), param.get("roomid"));
			return new ResponseEntity<String>("신청이 완료되었습니다", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/selectMember")
	public ResponseEntity<TeamMember> selectTeamMember(@RequestParam("state") Long state, @RequestParam("roomid") String roomid){
		try {
			return new ResponseEntity<TeamMember> (memberservice.selectTeamMember(state, roomid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TeamMember> (HttpStatus.BAD_REQUEST);
		}
	}
}
