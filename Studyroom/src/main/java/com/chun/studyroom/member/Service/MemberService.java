package com.chun.studyroom.member.Service;

import com.chun.studyroom.member.DTO.MemberDTO;

public interface MemberService {
	void insertmember(MemberDTO member);
	void selectmember(String id, String password) throws Exception;
}
