package com.chun.studyroom.room.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.room.DTO.RoomDTO;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomrepository;

	@Override
	public void makeroom(RoomDTO roomdto) {
		Room room = new Room();
		room.setRoomContent(roomdto.getRoomContent());
		room.setRoomDeadline(roomdto.getRoomDeadline());
		room.setRoomOnline(roomdto.getRoomOnline());
		room.setRoomPeriod(roomdto.getRoomPeriod());
		room.setRoomPersonnel(roomdto.getRoomPersonnel());
		room.setRoomTitle(roomdto.getRoomTitle());
		roomrepository.save(room);
	}

	@Override
	public List<RoomDTO> selectAllRoom() {
		List<Room> room = roomrepository.findAll();
		List<RoomDTO> rooms = new ArrayList<RoomDTO>();
		for (Room room2 : room) {
			RoomDTO roomdto = new RoomDTO();
			roomdto.setRoomContent(room2.getRoomContent());
			roomdto.setRoomDeadline(room2.getRoomDeadline());
			roomdto.setRoomId(room2.getRoomId());
			roomdto.setRoomPeriod(room2.getRoomPeriod());
			roomdto.setRoomPersonnel(room2.getRoomPersonnel());
			roomdto.setRoomTitle(room2.getRoomTitle());
			roomdto.setRoomOnline(room2.getRoomOnline());
			rooms.add(roomdto);
		}
		return rooms;
	}

	@Override
	public RoomDTO selectroom(Long id) throws Exception {
		Optional<Room> rRoom = (roomrepository.findById(id));
		RoomDTO room = new RoomDTO();
		room.setRoomContent(rRoom.get().getRoomContent());
		room.setRoomDeadline(rRoom.get().getRoomDeadline());
		room.setRoomId(rRoom.get().getRoomId());
		room.setRoomOnline(rRoom.get().getRoomOnline());
		room.setRoomPeriod(rRoom.get().getRoomPeriod());
		room.setRoomPersonnel(rRoom.get().getRoomPersonnel());
		room.setRoomTitle(rRoom.get().getRoomTitle());
		return room;
	}

}
