package com.chun.studyroom.member.DTO;

import java.util.List;

import com.chun.studyroom.room.Entity.Room;

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
	private String filename;
	private List<Room> rooms;
}
