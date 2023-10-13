package com.chun.studyroom.community.DTO;

import java.util.List;

import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.member.Entity.TeamMember;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommunityDTO {
	private Long community_id;
	private String title;
	private String content;
	private String filename;
	private Member member;
	private Long like_count;
}	
