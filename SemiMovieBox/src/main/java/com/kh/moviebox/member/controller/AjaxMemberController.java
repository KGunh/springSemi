package com.kh.moviebox.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.moviebox.member.model.service.MemberService;

@RestController
@RequestMapping("member")
public class AjaxMemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("idCheck")
	public String idCheck(String checkId) {
		return memberService.idCheck(checkId) > 0? "N" : "Y";
	}
}
