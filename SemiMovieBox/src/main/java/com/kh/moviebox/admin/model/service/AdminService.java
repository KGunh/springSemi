package com.kh.moviebox.admin.model.service;

import java.util.List;

import com.kh.moviebox.common.model.vo.Location;
import com.kh.moviebox.movie.model.vo.Movie;
import com.kh.moviebox.theater.model.vo.Screen;
import com.kh.moviebox.theater.model.vo.Theater;

public interface AdminService {
	List<Location> locationList();
	
	List<Theater> selectTheaterList(String locationCode);

	List<Screen> detailTheater(Screen sc);

	int insertScreen(Screen sc);

	List<Movie> movieList();

	int insertCheck(Screen sc);

	
}
