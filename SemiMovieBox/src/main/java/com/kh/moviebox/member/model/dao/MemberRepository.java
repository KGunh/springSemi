package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository // 저장소 관련된 작업(영성속)을 처리하겠다는 뜻
public class MemberRepository {
	
	
	public Member login(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
	public int insert(SqlSessionTemplate sqlSession,Member member) {
		return sqlSession.insert("memberMapper.insert",member);
	}
}
