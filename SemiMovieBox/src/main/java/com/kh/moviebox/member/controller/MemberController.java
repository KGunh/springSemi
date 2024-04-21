package com.kh.moviebox.member.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.moviebox.member.model.service.MemberService;
import com.kh.moviebox.member.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; 
	
	@RequestMapping("loginForm.member")
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping("login.member")
	public ModelAndView login(Member member, HttpSession session,ModelAndView mv) {

		
		// 하지만 Member테이블의 USER_PWD컬럼에는 암호문이 들어있기 때문에
		// WHERE 조건절의 조건식이 절대로 true가 될 수 없음
		
		Member loginUser = memberService.login(member);
		
		// Member member의 userPwd 필드 : 사용자가 입력한 비밀번호
		// Member loginUser의 userPwd필드 : DB에 ㅇ기록된 암호화된 비밀번호
		// 암호문에 포함되어있는 버전과 반복횟수와 소금값을 가지고 인자로 전달된 평문을 다시 암호화를 거쳐
		// 두 번째 인자로 전달된 암호문과 같은지 다른지를 비교한 결과값을 반환
		if(loginUser != null && bcryptPasswordEncoder.matches(member.getMemberPwd(), loginUser.getMemberPwd())) {
			
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg","로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping("logout.member")
	public ModelAndView logout(HttpSession session,ModelAndView mv) {
		
		session.removeAttribute("loginUser");
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	
	
	/*
	@RequestMapping("logout.member")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginUser");

		
		return "redirect:/";
	}
	
	*/
	@RequestMapping("enrollForm.member")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	@RequestMapping("insert.member")
	public ModelAndView insertMember(Member member,ModelAndView mv,HttpSession session) {
		
		// System.out.println(member);
		// 1. 한글 문자가 깨짐 => 인코딩
		// 2. 나이를 입력하지 않았을 경우 int자료형에 빈 문자열이 넘어오기 때문에
		// 파싱과정에서 String -> int NumberFormatException 발생함
		// 클라이언트에게는 400 Bad Request가 됨
		// 3. 비밀번호가 사용자가 입력한 있는 그대로의 평문(plain text)
		// Bcrypt방식을 사용해서 암호화 => Spring Security Module 제공~(pom.xml)
		// BCrypt클래스를 .xml 파일 이용해서 configurationBean으로 Bean으로 등록
		// ==> web.xml 에서 spring-security.xml파일을 로딩할 수 있도록 추가
		
		// System.out.println("평문 : " + member.getUserPwd());
		// 암호화작업(암호문을 만들어내는 과정)
		String encPwd = bcryptPasswordEncoder.encode(member.getMemberPwd());
		// System.out.println("암호문 : " + encPwd);
		member.setMemberPwd(encPwd);
		
		
		
		if(memberService.insert(member) > 0) {
			session.setAttribute("alertMsg", "가입성공");
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("errorMsg","회원가입 실패").setViewName("common/errorPage");
		}
		
		
		
		return mv;
		
		
	}
	
	@RequestMapping("myPage.member")
	public String myPage() {
		
		return "member/myPage";
	}
	
	
}
