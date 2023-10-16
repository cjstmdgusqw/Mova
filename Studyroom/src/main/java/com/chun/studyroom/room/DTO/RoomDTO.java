package com.chun.studyroom.room.DTO;

import com.chun.studyroom.member.Entity.Member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RoomDTO {
	private Long roomId;
	private String roomPersonnel;
	private String roomOnline;
	private String roomPeriod;
	private String roomDeadline;
	private String roomTitle;
	private String roomContent;
	private Member member;
	private Long memberId;
	private String memberleader;
	private String link;
}
