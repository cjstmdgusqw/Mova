package com.chun.studyroom.announcement.DTO;

import java.time.LocalDate;

import com.chun.studyroom.room.Entity.Room;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AnnouncementDTO {
	private Long announcement_id;
	private String announcement_title;
	private String announcement_content;
	private int view_count;
	private LocalDate creation_date;
	private Room room;
	private Long room_id;
}
