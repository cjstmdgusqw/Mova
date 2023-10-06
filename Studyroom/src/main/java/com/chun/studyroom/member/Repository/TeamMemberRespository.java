package com.chun.studyroom.member.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.member.Entity.TeamMember;

public interface TeamMemberRespository extends JpaRepository<TeamMember, Long> {
	@Query(value="SELECT * FROM team_member where member_member_id= :id and room_room_id=:roomid", nativeQuery = true)
	TeamMember check(@Param("id") Long id, @Param("roomid") Long password);
	
	@Query(value="SELECT * FROM team_member where state=:state and room_room_id=:roomid", nativeQuery = true)
	List<TeamMember> selectTeamMember(@Param("state") Long state, @Param("roomid") String roomid);
	
	@Query(value="SELECT * FROM team_member where state=:state and room_room_id=:roomid", nativeQuery = true)
	List<TeamMember> selectApplyTeamMember(@Param("state") Long state, @Param("roomid") String roomid);
	
	@Query(value="SELECT * FROM team_member where member_member_id=:id", nativeQuery = true)
	List<TeamMember> selectCorrectRoom(@Param("id") String id);
}
