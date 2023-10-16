package com.chun.studyroom.member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.member.Entity.Member;

public interface MemberRespository extends JpaRepository<Member, Long> {
	
	@Query(value="SELECT * FROM member where id= :id and password= :password", nativeQuery = true)
	Member selectMember(@Param("id") String id, @Param("password") String password);
	
	@Query(value="select member_id from member where id=:id", nativeQuery = true)
	Long selectmemberId(@Param("id") String id);
	
	@Query(value="select * from member where id=:memberid", nativeQuery = true)
	Member selectMember2(@Param("memberid") String memberid);

}
