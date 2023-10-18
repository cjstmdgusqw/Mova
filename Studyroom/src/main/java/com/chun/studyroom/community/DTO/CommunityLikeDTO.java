package com.chun.studyroom.community.DTO;

import com.chun.studyroom.community.Entity.Community;
import com.chun.studyroom.member.Entity.Member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommunityLikeDTO {
	private Long like_id;
	private Member member;
	private Community community;
}
