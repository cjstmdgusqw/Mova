package com.chun.studyroom.resume.DTO;

import com.chun.studyroom.member.Entity.Member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ResumeDTO {
	private Long resumeId;
	private String age;
	private String phonenumber;
	private String title;
	private String content;
	private String memberid;
	private Member member;
}
