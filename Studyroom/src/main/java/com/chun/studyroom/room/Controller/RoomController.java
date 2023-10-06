package com.chun.studyroom.room.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chun.studyroom.room.DTO.RoomDTO;
import com.chun.studyroom.room.Service.RoomService;

@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
	private RoomService roomservice;
	
	@PostMapping("makeroom")
	public ResponseEntity<String> makeroom(@ModelAttribute RoomDTO roomDto){
		try {
			roomservice.makeroom(roomDto);
			return new ResponseEntity<String>("방 개설이 완료 되었습니다", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("selectAllroom")
	public ResponseEntity<List<RoomDTO>> selectAllroom(){
		try {
			return new ResponseEntity<List<RoomDTO>>(roomservice.selectAllRoom(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<RoomDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("selectroom/{id}")
	public ResponseEntity<RoomDTO> selectroom(@PathVariable Long id){
		try {
			return new ResponseEntity<RoomDTO>(roomservice.selectroom(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RoomDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("selectmypage")
	public ResponseEntity<List<RoomDTO>> selectmypageroom(@RequestParam String id){
		try {
			return new ResponseEntity<List<RoomDTO>>(roomservice.selectMypageRoom(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<RoomDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("selectcorrectroom")
	public ResponseEntity<List<RoomDTO>> selectCorrectRoom(@RequestParam String id){
		try {
			return new ResponseEntity<List<RoomDTO>>(roomservice.selectCorrectRoom(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<RoomDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
