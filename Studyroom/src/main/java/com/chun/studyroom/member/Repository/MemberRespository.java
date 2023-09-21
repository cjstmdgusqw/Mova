package com.chun.studyroom.member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chun.studyroom.member.Entity.Member;

public interface MemberRespository extends JpaRepository<Member, Long> {

}
