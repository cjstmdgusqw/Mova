package com.chun.studyroom.room.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chun.studyroom.room.Entity.Room;

public interface RoomRespository extends JpaRepository<Room, Long> {

}
