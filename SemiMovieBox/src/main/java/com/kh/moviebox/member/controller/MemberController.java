package com.kh.moviebox.member.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.moviebox.common.model.vo.Genre;
import com.kh.moviebox.member.model.service.MemberService;
import com.kh.moviebox.member.model.vo.Member;
import com.kh.moviebox.reservation.model.vo.Reservation;

@Controller
@RequestMapping(value="member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; 
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping()
	public ModelAndView login(Member member, HttpSession session,ModelAndView mv) {


		
		Member loginUser = memberService.login(member);
		

		if(loginUser != null && bcryptPasswordEncoder.matches(member.getMemberPwd(), loginUser.getMemberPwd())) {
			
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg","로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	@GetMapping("logout")
	public ModelAndView logout(HttpSession session,ModelAndView mv) {
		
		session.removeAttribute("loginUser");
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	

	@RequestMapping("enrollForm")
	public String enrollForm() {
		return "member/memberInsert";
	}
	
	@RequestMapping("insert.member")
	public ModelAndView insertMember(Member member,String[] genres, ModelAndView mv,HttpSession session) {
		
		List<Genre> genreList = new ArrayList();
		if (genres != null) {
		    for (int i = 0; i < genres.length; i++) {
		        Genre g = new Genre();
		        g.setGenreName(genres[i]);
		        genreList.add(g);
		    }
		}
		member.setGenreList(genreList);
		String encPwd = bcryptPasswordEncoder.encode(member.getMemberPwd());

		member.setMemberPwd(encPwd);
		
		if(memberService.insert(member) > 0) {
			session.setAttribute("alertMsg", "가입성공");
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("errorMsg","회원가입 실패").setViewName("common/errorPage");
		}
		return mv;
		
	}
	
	@RequestMapping("myPage")
	public ModelAndView myPage(ModelAndView mv,HttpSession session) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mv.setViewName("redirect:/");
			return mv;
		} else {
			mv.addObject("list",memberService.myPagePrint(loginUser)).addObject("boardList",memberService.myPageBoardPrint(loginUser)).setViewName("member/myPage");
			return mv;
		}
		
		
		
	}
	
	@RequestMapping("resList.member")
	public ModelAndView myReservation(ModelAndView mv,HttpSession session) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd, HH:mm");
		
		Date current = new Date();
		
		boolean isBeforeCurrent = true;
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			mv.setViewName("redirect:/");
			return mv;
		} else {
			List<Reservation> list = memberService.myPagePrint(loginUser);
			if(list.isEmpty()) {
				mv.setViewName("member/myReservation");
				return mv;
			} else {
				for(int i = 0; i < list.size(); i++) {
					try {
						Date watchDate = dateFormat.parse(list.get(i).getWatchDate());
						
						isBeforeCurrent = watchDate.before(current);
						
						list.get(i).setBeforeCurrent(isBeforeCurrent);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				mv.addObject("list",list).setViewName("member/myReservation");
				return mv;
			}
		}
		
		
	}

}
