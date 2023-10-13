package com.chun.studyroom.community.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.community.Entity.CommunityComment;
import com.chun.studyroom.community.Entity.Communitylike;

public interface CommunityLikeRepository extends JpaRepository<Communitylike, Long> {
	@Query(value="DELETE FROM communitylike where community_community_id=:communityId and member_member_id=:memberid", nativeQuery = true)
	void deletelike(@Param("communityId") String communityId, @Param("memberid") Long memberid);
	
	@Query(value="SELECT count(*) as count FROM communitylike where community_community_id=:communityId and member_member_id=:memberid", nativeQuery = true)
	Integer checklike(@Param("communityId") String communityId, @Param("memberid") Long memberid);
}
