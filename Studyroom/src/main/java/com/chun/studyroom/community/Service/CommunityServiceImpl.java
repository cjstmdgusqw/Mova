package com.chun.studyroom.community.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.community.DTO.CommunityDTO;
import com.chun.studyroom.community.Entity.Community;
import com.chun.studyroom.community.Repository.CommunityRepository;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Repository.TeamMemberRespository;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
import com.chun.studyroom.util.FileService;
@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private TeamMemberRespository teammemberRepo;
	
	@Autowired
	private RoomRespository roomRepo;
	
	@Autowired
	private CommunityRepository communityRepo;

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
		community.setFilename(communitydto.getFilename());
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

}
