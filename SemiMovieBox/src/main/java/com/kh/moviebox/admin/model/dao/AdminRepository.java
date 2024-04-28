package com.kh.moviebox.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.moviebox.common.model.vo.Location;
import com.kh.moviebox.movie.model.vo.Movie;
import com.kh.moviebox.theater.model.vo.Screen;
import com.kh.moviebox.theater.model.vo.Theater;

@Repository
public class AdminRepository {

	public List<Location> locationList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("adminMapper.locationList");
	}

	public List<Theater> selectTheaterList(SqlSessionTemplate sqlSession, String locationCode) {
		return sqlSession.selectList("adminMapper.selectTheaterList",locationCode);
	}

	public List<Screen> detailTheater(SqlSessionTemplate sqlSession, Screen sc) {
		return sqlSession.selectList("adminMapper.detailTheater",sc);
	}

	public int insertScreen(SqlSessionTemplate sqlSession, Screen sc) {
		return sqlSession.insert("adminMapper.insertScreen",sc);
	}

	public List<Movie> movieList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("adminMapper.movieList");
	}

	public int insertCheck(SqlSessionTemplate sqlSession, Screen sc) {
		return sqlSession.selectOne("adminMapper.insertCheck", sc);
	}

}
