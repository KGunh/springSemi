package com.kh.moviebox.member.model.vo;

import java.sql.Date;
import java.util.List;

import com.kh.moviebox.common.model.vo.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@NoArgsConstructor
@Setter
@ToString
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String birthday;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private Date enrollDate;
	private String status;
	private String privilege;
	private String localCode;
	private String localName;
	private List<Genre> genreList;
	
	
	
	
}
