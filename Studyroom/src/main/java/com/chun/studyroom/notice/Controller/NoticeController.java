package com.chun.studyroom.notice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.notice.Service.NoticeService;
import com.chun.studyroom.room.DTO.RoomDTO;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeservice;
	
	@GetMapping("selectnotice/{id}")
	public ResponseEntity<RoomDTO> noticeroom(@PathVariable Long id){
		try {
			return new ResponseEntity<RoomDTO>(noticeservice.selectnotice(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RoomDTO>(HttpStatus.BAD_REQUEST);
		}
	}
}
