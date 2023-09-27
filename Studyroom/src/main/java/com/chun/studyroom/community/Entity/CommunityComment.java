package com.chun.studyroom.community.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chun.studyroom.member.Entity.TeamMember;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityComment {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long comment_id;
	
	@Column
	private String comment_content;
	
	@Column
	private LocalDateTime comment_date;
	
	@ManyToOne
	private Community comment;
	
	@ManyToOne
	private TeamMember teammember;
}
