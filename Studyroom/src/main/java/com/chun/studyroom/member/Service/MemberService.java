package com.chun.studyroom.member.Service;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.TeamMember;

public interface MemberService {
	void insertmember(MemberDTO member);
	String selectmember(String id, String password) throws Exception;
	Long memberid(String id) throws Exception;
	void applyteam(Long id, Long roomid);
	
	
	TeamMember check(Long id, Long roomid);
	TeamMember selectTeamMember(Long state, String roomid);
}
