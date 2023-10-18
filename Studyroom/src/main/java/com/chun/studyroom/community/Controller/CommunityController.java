package com.chun.studyroom.community.Controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.chun.studyroom.community.DTO.CommunityCommentDTO;
import com.chun.studyroom.community.DTO.CommunityDTO;
import com.chun.studyroom.community.Entity.CommunityComment;
import com.chun.studyroom.community.Repository.CommunityCommentRepository;
import com.chun.studyroom.community.Service.CommunityService;

@RestController
@RequestMapping("community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityservice;
	
	@PostMapping("/writefeed/{roomid}")
	public ResponseEntity<String> insertCommunity(@PathVariable Long roomid,  @ModelAttribute CommunityDTO communitydto
			,@RequestParam(value = "file", required=false) MultipartFile[] file, @RequestParam("memberid") String memberid){
		try {
			communityservice.writefeed(roomid, memberid, communitydto, file);
			return new ResponseEntity<String> ("작성완료", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/selectfeed")
	public ResponseEntity<List<CommunityDTO>> selectCommunity(@RequestParam Long roomid){
		try {
			return new ResponseEntity<List<CommunityDTO>> (communityservice.selectfeed(roomid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<CommunityDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/detailfeed")
	public ResponseEntity<CommunityDTO> detailCommunity(@RequestParam Long communityId){
		try {
			return new ResponseEntity<CommunityDTO> (communityservice.detailfeed(communityId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CommunityDTO> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/writecomment")
	public ResponseEntity<String> writecomment(@ModelAttribute CommunityCommentDTO commentDTO){
		try {
			communityservice.writeComment(commentDTO);
			return new ResponseEntity<String> ("댓글 작성완료", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/selectcomment")
	public ResponseEntity<List<CommunityCommentDTO>> selectcomment(@RequestParam String communityId){
		try {
			return new ResponseEntity<List<CommunityCommentDTO>>(communityservice.selectComment(communityId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<CommunityCommentDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("increaselike")
	public ResponseEntity<String> increaselike(@RequestParam String communityId, @RequestParam Long memberId) {
		try {
			communityservice.increaselike(communityId,memberId);
			return new ResponseEntity<String> ("좋아요", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("decreaselike")
	public ResponseEntity<String> decreaselike(@RequestParam String communityId,  @RequestParam Long memberId) {
		try {
			communityservice.decreaselike(communityId, memberId);
			return new ResponseEntity<String> ("좋아요 취소", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("checklike")
	public ResponseEntity<Integer> checklike(@RequestParam String communityId,  @RequestParam Long memberId) {
		try {
			return new ResponseEntity<Integer> (communityservice.checklike(communityId, memberId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer> (HttpStatus.BAD_REQUEST);
		}
	}
}
