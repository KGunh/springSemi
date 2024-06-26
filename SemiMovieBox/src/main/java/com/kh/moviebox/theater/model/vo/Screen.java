package com.kh.moviebox.theater.model.vo;

import java.util.List;

import com.kh.moviebox.movie.model.vo.Movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString @NoArgsConstructor
public class Screen {
	private int screenNo;
	private int theaterNo;
	private int movieNo;
	private String watchDate;
	private String watchTime;
	private int screenName;
	private String theaterName;
	private String movieTitle;
	private int movieRt;
	
	
	private List<Integer> screenNoList;
	private List<String> screenNameList;
	
	private List<String> watchDateList;
	private List<Movie> movieList;
	private List<Movie> movieNameList;
}
