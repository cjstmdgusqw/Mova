package com.chun.studyroom.member.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import com.chun.studyroom.room.Entity.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TeamMember {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long team_member_id;
	
	@Column(nullable = true)
	private Integer state;
	
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Room room;
}
