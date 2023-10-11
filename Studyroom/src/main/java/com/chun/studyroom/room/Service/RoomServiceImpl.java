package com.chun.studyroom.room.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.member.Entity.TeamMember;
import com.chun.studyroom.member.Repository.MemberRespository;
import com.chun.studyroom.member.Repository.TeamMemberRespository;
import com.chun.studyroom.room.DTO.RoomDTO;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomrepository;
	
	@Autowired
	private MemberRespository memberrepository;
	
	@Autowired
	private TeamMemberRespository teammemberrespository;

	@Override
	public void makeroom(RoomDTO roomdto) {
		Room room = new Room();
		room.setRoomContent(roomdto.getRoomContent());
		room.setRoomDeadline(roomdto.getRoomDeadline());
		room.setRoomOnline(roomdto.getRoomOnline());
		room.setRoomPeriod(roomdto.getRoomPeriod());
		room.setRoomPersonnel(roomdto.getRoomPersonnel());
		room.setRoomTitle(roomdto.getRoomTitle());	
		System.out.println(roomdto.getMemberId());
		
		Optional<Member> member = memberrepository.findById(roomdto.getMemberId());
		room.setMember(member.get());
		roomrepository.save(room);
		
		TeamMember teammember = new TeamMember();
		teammember.setState(2);
		teammember.setMember(member.get());
		teammember.setRoom(room);
		teammemberrespository.save(teammember);
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
		Room rRoom = roomrepository.findById(id).get();
		RoomDTO room = new RoomDTO();
		room.setRoomContent(rRoom.getRoomContent());
		room.setRoomDeadline(rRoom.getRoomDeadline());
		room.setRoomId(rRoom.getRoomId());
		room.setRoomOnline(rRoom.getRoomOnline());
		room.setRoomPeriod(rRoom.getRoomPeriod());
		room.setRoomPersonnel(rRoom.getRoomPersonnel());
		room.setRoomTitle(rRoom.getRoomTitle());
		room.setMember(rRoom.getMember());
		return room;
	}

	@Override
	public List<RoomDTO> selectMypageRoom(String id, Long state) throws Exception {
		List<TeamMember> teammember = teammemberrespository.selectCorrectRoom(id, state);
		List<RoomDTO> roomDTO = new ArrayList<RoomDTO>();
		for(TeamMember member : teammember) {
			RoomDTO roomdto = new RoomDTO();
			roomdto.setRoomId(member.getRoom().getRoomId());
			roomdto.setRoomTitle(member.getRoom().getRoomTitle());
			roomdto.setRoomContent(member.getRoom().getRoomContent());
			roomdto.setMemberId(member.getRoom().getMember().getMemberId());
			roomdto.setMemberleader(member.getRoom().getMember().getNickname());
			roomDTO.add(roomdto);
		}
		return roomDTO;
	}

	@Override
	public List<RoomDTO> selectCorrectRoom(String id, Long state) throws Exception {
		List<TeamMember> teammember = teammemberrespository.selectCorrectRoom(id, state);
		List<RoomDTO> roomDTO = new ArrayList<RoomDTO>();
		for(TeamMember member : teammember) {
			RoomDTO roomdto = new RoomDTO();
			roomdto.setRoomId(member.getRoom().getRoomId());
			roomdto.setRoomTitle(member.getRoom().getRoomTitle());
			roomdto.setRoomContent(member.getRoom().getRoomContent());
			roomdto.setMemberId(member.getRoom().getMember().getMemberId());
			roomdto.setMemberleader(member.getRoom().getMember().getNickname());
			roomDTO.add(roomdto);
		}
		return roomDTO;
	}

}
