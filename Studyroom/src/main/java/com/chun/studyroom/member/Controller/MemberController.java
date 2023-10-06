package com.chun.studyroom.member.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Service.MemberService;
import com.chun.studyroom.util.FileService;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private FileService fileService;  
	
//	회원가입
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@ModelAttribute MemberDTO memberDto, 
			@RequestParam(value = "file", required=false) MultipartFile file){
		try {
			memberservice.insertmember(memberDto, file);
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
//	팀 멤버 조회
	@GetMapping("/selectMember")
	public ResponseEntity<List<TeamMember>> selectTeamMember(@RequestParam("state") Long state, @RequestParam("roomid") String roomid){
		try {
			return new ResponseEntity<List<TeamMember>> (memberservice.selectTeamMember(state, roomid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<TeamMember>> (HttpStatus.BAD_REQUEST);
		}
	}
//	신청 멤버 조회
	@GetMapping("/selectApplyMember")
	public ResponseEntity<List<TeamMember>> selectApplyTeamMember(@RequestParam("state") Long state, @RequestParam("roomid") String roomid){
		try {
			return new ResponseEntity<List<TeamMember>> (memberservice.selectApplyTeamMember(state, roomid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<TeamMember>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/correct")
	public ResponseEntity<String> correctTeamMember(@RequestParam("teamMemberId") Long teamMemberId){
		try {
			memberservice.correctTeamMember(teamMemberId);
			return new ResponseEntity<String>("신청을 수락하였습니다",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/fail")
	public ResponseEntity<String> failTeamMember(@RequestParam("teamMemberId") Long teamMemberId){
		try {
			memberservice.failTeamMember(teamMemberId);
			return new ResponseEntity<String>("신청을 거절하였습니다",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/view/{imgName}")
	public void image(@PathVariable("imgName") String imgName, HttpServletResponse response) {
		try {
			fileService.fileView(imgName, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("mypage")
	public ResponseEntity<MemberDTO> mypage(@RequestParam("id") String memberid){
		try {
			return new ResponseEntity<MemberDTO>(memberservice.mypage(memberid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<MemberDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
