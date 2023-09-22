package com.chun.studyroom.member.Service;

import java.util.Optional;

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

	@Override
	public void selectmember(String id, String password) throws Exception {
		Optional<Member> omember = memberrespository.findById(id);
		if(omember.isEmpty()) {
			throw new Exception("아이디 오류");
		}
		Member member = omember.get();
		if(!member.getPassword().equals(password)) {
			throw new Exception("비밀번호 오류");
		}
	}
}
