package com.chun.studyroom.notice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chun.studyroom.room.Entity.Room;

public interface NoticeRepository extends JpaRepository<Room, Long> {

}
