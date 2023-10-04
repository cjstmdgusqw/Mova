package com.chun.studyroom.announcement.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chun.studyroom.announcement.DTO.AnnouncementDTO;
import com.chun.studyroom.announcement.Entity.Announcement;
import com.chun.studyroom.announcement.Repository.AnnouncementRespository;
import com.chun.studyroom.room.Entity.Room;
import com.chun.studyroom.room.Respository.RoomRespository;
@Service
public class AnnouncementServiceImpl implements AnnouncementService{
	
	@Autowired
	private AnnouncementRespository announcementRepo;
	
	@Autowired
	private RoomRespository roomRepo;

	@Override
	public void insertAnnouncement(AnnouncementDTO announcementdto) {
		Optional<Room> room = roomRepo.findById(announcementdto.getRoom_id());
		Announcement anncouncement = new Announcement();
		anncouncement.setAnnouncement_content(announcementdto.getAnnouncement_content());
		anncouncement.setAnnouncement_title(announcementdto.getAnnouncement_title());
		anncouncement.setCreation_date(LocalDate.now());
		anncouncement.setView_count(0);
		anncouncement.setRoom(room.get());
		announcementRepo.save(anncouncement);
	}

	@Override
	public List<AnnouncementDTO> selectAnnouncement(Long roomid) {
		List<Announcement> announcement = announcementRepo.selectAnnouncement(roomid);
		List<AnnouncementDTO> announcements = new ArrayList<AnnouncementDTO> ();
		for(Announcement announcement2 : announcement) {
			AnnouncementDTO announcementdto = new AnnouncementDTO();
			announcementdto.setAnnouncement_id(announcement2.getAnnouncement_id());
			announcementdto.setAnnouncement_title(announcement2.getAnnouncement_title());
			announcementdto.setAnnouncement_content(announcement2.getAnnouncement_content());
			announcementdto.setRoom(announcement2.getRoom());
			announcementdto.setCreation_date(announcement2.getCreation_date());
			announcementdto.setView_count(announcement2.getView_count());
			announcements.add(announcementdto);
		}
		return announcements;
	}
}	
