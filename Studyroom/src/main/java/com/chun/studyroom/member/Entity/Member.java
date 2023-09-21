package com.chun.studyroom.member.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {
	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long memberID;
	
	@Column
	private String Id;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String nickname;
	
	
}
