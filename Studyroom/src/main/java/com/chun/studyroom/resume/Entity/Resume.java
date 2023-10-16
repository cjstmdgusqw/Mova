package com.chun.studyroom.resume.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chun.studyroom.member.Entity.Member;
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
public class Resume {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long resumeid;
	
	@Column
	private String age;
	
	@Column 
	private String phoneumber;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@ManyToOne
	private Member member;
	
}
