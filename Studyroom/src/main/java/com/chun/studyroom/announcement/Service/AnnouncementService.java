package com.chun.studyroom.announcement.Service;

import java.util.List;

import com.chun.studyroom.announcement.DTO.AnnouncementDTO;

public interface AnnouncementService {
	public void insertAnnouncement(AnnouncementDTO announcementdto);
	public List<AnnouncementDTO> selectAnnouncement(Long roomid);
	public AnnouncementDTO detailAnnouncement(Long roomid, Long announcementId);
}
