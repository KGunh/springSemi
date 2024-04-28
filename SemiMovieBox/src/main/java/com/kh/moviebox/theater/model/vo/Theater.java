package com.kh.moviebox.theater.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Theater {
	private int theaterNo;
	private String theaterName;
	private String theaterAddr;
	private String mapLink;
	private String localCode;
	private String updateDate;
	private String locationName;
	
	private String watchDate;
	private int screenNo;
	private int movieNo;
	private String movieTitle;
	
	private String filePath;
	private String changeName;
	
}
