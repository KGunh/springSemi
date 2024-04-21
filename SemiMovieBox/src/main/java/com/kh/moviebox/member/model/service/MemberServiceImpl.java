package com.kh.spring.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberRepository;
import com.kh.spring.member.model.vo.Member;
// @Component == Bean으로 등록하겠다
@Service // Component보다 더 구체적으로 ServiceBean으로 등록하겠다.
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member login(Member member) {
		 
		
		
		// System.out.println("로그인");
		// Member loginMember = memberRepository.login(sqlSession, member);
		// SqlSessionTemplate 객체를 Bean으로 등록@Autowired
		// 스프링이 사용 후 자동으로 객체를 알아서 반납시켜주기 떄문에 close()를 호출하지 않음
		
		return memberRepository.login(sqlSession, member);
	}

	@Override
	public int insert(Member member) {
		// memberRepository.insert(sqlSession, member);
		// SqlSessionTemplate 객체가 자동으로 commit해줌
		return memberRepository.insert(sqlSession, member);
	}

	@Override
	public int update(Member member) {
		return 0;
	}

	@Override
	public int delete(Member member) {
		return 0;
	}
	
	
	
	
}
