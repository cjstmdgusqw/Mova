package com.chun.studyroom.announcement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.announcement.DTO.AnnouncementDTO;
import com.chun.studyroom.announcement.Service.AnnouncementService;

@RestController
@RequestMapping("announcement")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementservice;
	
	@PostMapping("write")
	public ResponseEntity<String> writeannouncement(@ModelAttribute AnnouncementDTO announcedto){
		try {
			announcementservice.insertAnnouncement(announcedto);
			return new ResponseEntity<String>("공지사항 작성이 완료되었습니다", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("selectannouncement")
	public ResponseEntity<List<AnnouncementDTO>> selectannouncement(@RequestParam("id") String id){
		try {
			return new ResponseEntity<List<AnnouncementDTO>>(announcementservice.selectAnnouncement(Long.parseLong(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AnnouncementDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
