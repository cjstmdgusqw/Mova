package com.chun.studyroom.community.DTO;

import com.chun.studyroom.member.Entity.Member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommunityCommentDTO {
	private String comment;
	private String memberid;
	private Long community_id;
	private Long roomid;
	
	private String filename;
	private String writer;
	
}
