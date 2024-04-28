package com.kh.moviebox.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private int count;
	private String status;
	private String boardWriter;
	private String boardCategory;
	private String answerNo;
	
	private int categoryNo;
	private int userNo;
}
