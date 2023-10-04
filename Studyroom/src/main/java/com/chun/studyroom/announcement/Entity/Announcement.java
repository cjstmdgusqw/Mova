package com.chun.studyroom.announcement.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chun.studyroom.room.Entity.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long announcement_id;
	
	@Column
	private String announcement_title;
	
	@Column
	private String announcement_content;

	@Column
    private LocalDate creation_date; // LocalDate로 변경
	
	@Column
	private int view_count;
	
	@ManyToOne
	private Room room;
}
