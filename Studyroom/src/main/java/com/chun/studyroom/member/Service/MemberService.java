package com.chun.studyroom.member.Service;

import com.chun.studyroom.member.DTO.MemberDTO;

public interface MemberService {
	void insertmember(MemberDTO member);
	String selectmember(String id, String password) throws Exception;
	Long memberid(String id) throws Exception;
	void applyteam(Long id, Long roomid);
}
