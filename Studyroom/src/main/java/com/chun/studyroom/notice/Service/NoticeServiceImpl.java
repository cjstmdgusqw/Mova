package com.chun.studyroom.notice.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.notice.Repository.NoticeRepository;
import com.chun.studyroom.room.DTO.RoomDTO;
import com.chun.studyroom.room.Entity.Room;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeRepository noticerepository;

	@Override
	public RoomDTO selectnotice(Long id) throws Exception {
		Optional<Room> rRoom = (noticerepository.findById(id));
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
