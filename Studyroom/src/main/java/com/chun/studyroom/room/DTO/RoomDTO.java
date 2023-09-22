package com.chun.studyroom.room.DTO;

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
}
