package com.chun.studyroom.member.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberDTO {
	private Long memberId;
	private String Id;
	private String password;
	private String name;
	private String nickname;
}
