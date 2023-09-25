package com.chun.studyroom.notice.Service;

import com.chun.studyroom.room.DTO.RoomDTO;

public interface NoticeService {
	RoomDTO selectnotice(Long id) throws Exception;
}
