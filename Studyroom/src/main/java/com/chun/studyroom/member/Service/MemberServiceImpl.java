package com.chun.studyroom.member.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Repository.MemberRespository;
import com.chun.studyroom.member.Repository.TeamMemberRespository;
import com.chun.studyroom.room.Respository.RoomRespository;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRespository memberrespository;
	
	@Autowired
	private RoomRespository roomrespository;
	
	@Autowired
	private TeamMemberRespository teammemberrespository;

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
	public String selectmember(String id, String password) throws Exception {
		Member Member = memberrespository.selectMember(id, password);
		if(Member.getId().isEmpty()) {
			return "정보를 다시 입력해주세요";
		}
		return "로그인인 완료되었습니다";
	}

	@Override
	public Long memberid(String id) throws Exception {
		return memberrespository.selectmemberId(id);
	}

	@Override
	public void applyteam(Long id, Long roomid) {
		TeamMember teammember = new TeamMember();
		teammember.setMember(memberrespository.findById(id).get());
		teammember.setRoom(roomrespository.findById(roomid).get());
		teammember.setState(0);
		teammemberrespository.save(teammember);
	}

	@Override
	public TeamMember check(Long id, Long roomid) {
		System.out.println(id);
		return teammemberrespository.check(id, roomid);
	}

	@Override
	public List<TeamMember> selectTeamMember(Long state, String roomid) {
		return teammemberrespository.selectTeamMember(state, roomid);
	}
}
