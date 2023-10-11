package com.chun.studyroom.community.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.community.Entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	@Query(value="SELECT * FROM community where room_room_id=:roomid", nativeQuery = true)
	List<Community> selectfeed(@Param("roomid") Long roomid);
}
