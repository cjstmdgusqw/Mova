package com.chun.studyroom.member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chun.studyroom.member.Entity.TeamMember;

public interface TeamMemberRespository extends JpaRepository<TeamMember, Long> {

}
