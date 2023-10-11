package com.chun.studyroom.member.Service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.member.DTO.MemberDTO;
import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Repository.MemberRespository;
import com.chun.studyroom.member.Repository.TeamMemberRespository;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
import com.chun.studyroom.util.FileService;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRespository memberrespository;
	
	@Autowired
	private RoomRespository roomrespository;
	
	@Autowired
	private TeamMemberRespository teammemberrespository;
	
	@Autowired
	private FileService fileService;  

	@Override
	public void insertmember(MemberDTO memberDto, MultipartFile file) {
		Member member = new Member();
		member.setId(memberDto.getId());
		member.setName(memberDto.getName());
		member.setNickname(memberDto.getNickname());
		member.setPassword(memberDto.getPassword());
		member.setFilename(memberDto.getFilename());
		fileService.fileUpload(file);
		
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

	@Override
	public List<TeamMember> selectApplyTeamMember(Long state, String roomid) {
		return teammemberrespository.selectApplyTeamMember(state, roomid);
	}

	@Override
	public void correctTeamMember(Long teammemberId) {
		TeamMember teammember = teammemberrespository.findById(teammemberId).get();
		teammember.setState(1);
		teammemberrespository.save(teammember);
	}

	@Override
	public void failTeamMember(Long teammemberId) {
		TeamMember teammember = teammemberrespository.findById(teammemberId).get();
		teammemberrespository.delete(teammember);
	}

	@Override
	public MemberDTO mypage(String id) throws Exception {
		Member member = memberrespository.findById(Long.parseLong(id)).get();
		MemberDTO memberdto = new MemberDTO();
		memberdto.setFilename(member.getFilename());
		memberdto.setId(member.getId());
		memberdto.setMemberId(member.getMemberId());
		memberdto.setName(member.getName());
		memberdto.setNickname(member.getNickname());
		memberdto.setPassword(member.getPassword());
		return memberdto;
	}
}
