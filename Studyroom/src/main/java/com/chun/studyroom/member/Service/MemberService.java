package com.chun.studyroom.member.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.TeamMember;

public interface MemberService {
	void insertmember(MemberDTO member,  MultipartFile file) throws Exception;
	String selectmember(String id, String password) throws Exception;
	Long memberid(String id) throws Exception;
	void applyteam(Long id, Long roomid) throws Exception;
	
	MemberDTO mypage(Long id) throws Exception;
	
	
	TeamMember check(Long id, Long roomid) throws Exception;
	List<TeamMember> selectTeamMember(Long state, String roomid) throws Exception;
	List<TeamMember> selectApplyTeamMember(Long state, String roomid) throws Exception;
	
	void correctTeamMember(Long memberId) throws Exception;
	void failTeamMember(Long memberId) throws Exception;
}
