package com.chun.studyroom.community.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chun.studyroom.community.Entity.Community;
import com.chun.studyroom.community.Entity.CommunityComment;

public interface CommunityCommentRepository extends JpaRepository<CommunityComment, Long> {
	@Query(value="SELECT * FROM community_comment where comment_community_id=:communityId", nativeQuery = true)
	List<CommunityComment> selectcomment(@Param("communityId") String communityId);
}
