package com.chun.studyroom.room.Service;

import java.util.List;

import com.chun.studyroom.room.DTO.RoomDTO;

public interface RoomService {
	void makeroom(RoomDTO roomdto) throws Exception;
	List<RoomDTO> selectAllRoom() throws Exception;
}
