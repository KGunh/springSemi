package com.kh.moviebox.admin.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moviebox.admin.model.dao.AdminRepository;
import com.kh.moviebox.common.model.vo.Location;
import com.kh.moviebox.movie.model.vo.Movie;
import com.kh.moviebox.theater.model.vo.Screen;
import com.kh.moviebox.theater.model.vo.Theater;

@Service
public class AdminServiceImpl implements AdminService {

	

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public List<Location> locationList() {
		return adminRepository.locationList(sqlSession);
	}


	@Override
	public List<Theater> selectTheaterList(String locationCode) {
		return adminRepository.selectTheaterList(sqlSession,locationCode);
	}


	@Override
	public List<Screen> detailTheater(Screen sc) {
		return adminRepository.detailTheater(sqlSession, sc);
	}


	@Override
	public int insertScreen(Screen sc) {
		return adminRepository.insertScreen(sqlSession, sc);
	}


	@Override
	public List<Movie> movieList() {
		return adminRepository.movieList(sqlSession);
	}


	@Override
	public int insertCheck(Screen sc) {
		return adminRepository.insertCheck(sqlSession, sc);
	}

}
