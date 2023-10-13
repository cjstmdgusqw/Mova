package com.chun.studyroom.community.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.community.DTO.CommunityCommentDTO;
import com.chun.studyroom.community.DTO.CommunityDTO;
import com.chun.studyroom.community.Entity.Community;
import com.chun.studyroom.community.Entity.CommunityComment;
import com.chun.studyroom.community.Entity.Communitylike;
import com.chun.studyroom.community.Repository.CommunityCommentRepository;
import com.chun.studyroom.community.Repository.CommunityLikeRepository;
import com.chun.studyroom.community.Repository.CommunityRepository;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Repository.MemberRespository;
import com.chun.studyroom.member.Repository.TeamMemberRespository;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
import com.chun.studyroom.util.FileService;
@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private FileService fileService;
	
	@Autowired 
	private MemberRespository memberRepo;
	
	@Autowired
	private TeamMemberRespository teammemberRepo;
	
	@Autowired
	private RoomRespository roomRepo;
	
	@Autowired
	private CommunityLikeRepository communityLikeRepo;
	
	@Autowired
	private CommunityRepository communityRepo;
	
	@Autowired
	private CommunityCommentRepository commentRepo;

	@Override
	public void writefeed(Long roomid, String memberid, CommunityDTO communitydto, MultipartFile[] file) {
		Community community = new Community();
		TeamMember teammember = teammemberRepo.TeamCorrectMember(memberid, roomid);
		Room room = roomRepo.findById(roomid).get();
		community.setComunity_content(communitydto.getContent());
		community.setComunity_title(communitydto.getTitle());
		community.setCommunity_date(LocalDate.now());
		community.setTeammember(teammember);
		community.setRoom(room);
		community.setFilename(communitydto.getFilename());;
		for(int i=0; i < file.length; i++) {
			if (file[i] != null && !file[i].isEmpty()) {
				fileService.fileUpload(file[i]);
			}
		}
		communityRepo.save(community);
	}

	@Override
	public List<CommunityDTO> selectfeed(Long roomid) {
		List<Community> community = communityRepo.selectfeed(roomid);
		List<CommunityDTO> communitys = new ArrayList<CommunityDTO>();
		for (Community community2 : community) {
			CommunityDTO communitydto = new CommunityDTO();
			communitydto.setContent(community2.getComunity_content());
			communitydto.setTitle(community2.getComunity_title());
			communitydto.setFilename(community2.getFilename());
			communitydto.setMember(community2.getTeammember().getMember());
			communitydto.setCommunity_id(community2.getCommunity_id());
			communitys.add(communitydto);
		}
		return communitys;
	}

	@Override
	public CommunityDTO detailfeed(Long communityId) {
		Community community = communityRepo.findById(communityId).get();
		CommunityDTO communitydto = new CommunityDTO();
		communitydto.setCommunity_id(community.getCommunity_id());
		communitydto.setContent(community.getComunity_content());
		communitydto.setFilename(community.getFilename());
		communitydto.setMember(community.getTeammember().getMember());
		communitydto.setTitle(community.getComunity_title());
		return communitydto;
	}

	@Override
	public void writeComment(CommunityCommentDTO commentDTO) {
		CommunityComment comment = new CommunityComment();
		List<TeamMember> member = teammemberRepo.TeamMember(commentDTO.getMemberid(), commentDTO.getRoomid());
		comment.setComment_content(commentDTO.getComment());
		comment.setTeammember(member.get(0));
		comment.setComment(communityRepo.findById(commentDTO.getCommunity_id()).get());
		commentRepo.save(comment);
	}

	@Override
	public List<CommunityCommentDTO> selectComment(String communityId) {
		List<CommunityComment> comments = commentRepo.selectcomment(communityId);
		List<CommunityCommentDTO> comment2 = new ArrayList<CommunityCommentDTO>();
		for (CommunityComment comment : comments) {
			CommunityCommentDTO com = new CommunityCommentDTO();
			com.setComment(comment.getComment_content());
			com.setFilename(comment.getTeammember().getMember().getFilename());
			com.setWriter(comment.getTeammember().getMember().getNickname());
			com.setMemberid(comment.getTeammember().getMember().getMemberId().toString());
			comment2.add(com);
		}
		return comment2;
	}

	@Override
	public void increaselike(String communityid, Long memberid) {
		Communitylike communitylike = new Communitylike();
		communitylike.setMember(memberRepo.findById(memberid).get());
		communitylike.setCommunity(communityRepo.findById(Long.parseLong(communityid)).get());
		communityLikeRepo.save(communitylike);
	}

	@Override
	public void decreaselike(String communityid, Long memberid) {
		communityLikeRepo.deletelike(communityid,memberid);
	}

	@Override
	public Integer checklike(String communityid, Long memberid) {
		return communityLikeRepo.checklike(communityid, memberid);
	}
	
}
