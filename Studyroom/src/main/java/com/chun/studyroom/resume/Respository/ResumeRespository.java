package com.chun.studyroom.resume.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.member.Entity.Member;
import com.chun.studyroom.resume.Entity.Resume;

public interface ResumeRespository extends JpaRepository<Resume, Long> {
	@Query(value="select * from resume where member_member_id=:Id", nativeQuery = true)
	List<Resume> selectResume(@Param("Id") Long Id);
}
