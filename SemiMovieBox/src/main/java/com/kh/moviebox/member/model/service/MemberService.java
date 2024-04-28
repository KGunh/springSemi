package com.kh.moviebox.member.model.service;

import java.util.List;

import com.kh.moviebox.board.model.vo.Board;
import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;

public interface MemberService {
	
	Member login(Member member);
	
	int insert(Member member);
	
	int update(Member member);
	
	int delete(Member member);
	
	List<Reservation> myPagePrint(Member member);
	
	List<Board> myPageBoardPrint(Member member);

	int idCheck(String checkId);



}
