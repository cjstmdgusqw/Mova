package com.chun.studyroom.community.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chun.studyroom.member.Entity.TeamMember;
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
public class Community {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long community_id;
	
	@Column
	private String comunity_title;
	
	@Column
	private String comunity_content;
	
	@Column
	private LocalDate community_date;
	
	@ManyToOne
	private Room room;
	
	@ManyToOne
	private TeamMember teammember;
	
	
    private String filename;
}
