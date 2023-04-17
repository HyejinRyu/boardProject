package com.board.bo.vo;

import lombok.Data;

@Data
public class BoardVo {

	private String idx;
	
	private String title;
	
	private String writer;
	
	private String content;

	private String ins_date;
	
	private int view_cnt;
}