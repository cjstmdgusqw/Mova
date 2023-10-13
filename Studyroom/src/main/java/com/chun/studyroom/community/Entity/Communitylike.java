package com.chun.studyroom.community.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chun.studyroom.member.Entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Communitylike {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long like_id;
	
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Community community;
}
