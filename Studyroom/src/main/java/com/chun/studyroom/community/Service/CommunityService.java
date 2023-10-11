package com.chun.studyroom.community.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.community.DTO.CommunityDTO;

public interface CommunityService {
	void writefeed(Long roomid, String memberid, CommunityDTO communitydto,  MultipartFile[] file);
	List<CommunityDTO> selectfeed(Long roomid);
}
