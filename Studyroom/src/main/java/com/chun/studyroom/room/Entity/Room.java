package com.chun.studyroom.room.Entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chun.studyroom.member.Entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="room")
public class Room {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	
	@Column
	private String roomPersonnel;
	
	@Column
	private String roomOnline;
	
	@Column 
	private String roomPeriod;
	
	@Column 
	private String roomDeadline;
	
	@Column
	private String roomTitle;
	
	@Column
	private String roomContent;
	
	@ManyToOne
	private Member member;
}
