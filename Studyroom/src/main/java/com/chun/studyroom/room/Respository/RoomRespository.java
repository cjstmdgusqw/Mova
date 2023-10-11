package com.chun.studyroom.room.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.room.DTO.RoomDTO;
import com.chun.studyroom.room.Entity.Room;

public interface RoomRespository extends JpaRepository<Room, Long> {
	@Query(value="SELECT * FROM room where member_member_id=:id and state=:state", nativeQuery = true)
	List<Room> selectMypageRoom(@Param("id") String id, @Param("state") Long state);
}
