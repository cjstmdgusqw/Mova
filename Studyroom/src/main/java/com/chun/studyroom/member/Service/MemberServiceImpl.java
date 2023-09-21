package com.chun.studyroom.member.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.member.Repository.MemberRespository;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRespository memberrespository;

	@Override
	public void insertmember(MemberDTO memberDto) {
		Member member = new Member();
		member.setId(memberDto.getId());
		member.setName(memberDto.getName());
		member.setNickname(memberDto.getNickname());
		member.setPassword(memberDto.getPassword());
		memberrespository.save(member);
	}

}
