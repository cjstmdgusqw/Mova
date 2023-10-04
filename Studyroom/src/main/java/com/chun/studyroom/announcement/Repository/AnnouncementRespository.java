package com.chun.studyroom.announcement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.announcement.Entity.Announcement;

public interface AnnouncementRespository extends JpaRepository<Announcement, Long> {
	@Query(value="select * from announcement where room_room_id=:roomid", nativeQuery = true)
	List<Announcement> selectAnnouncement(@Param("roomid") Long roomid);
}
