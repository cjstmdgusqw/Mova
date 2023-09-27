package com.chun.studyroom.announcement.Entity;

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
	
	@ManyToOne
	private Room room;
}
