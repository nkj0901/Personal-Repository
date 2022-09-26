package com.ssafy.board.dto;

public class Board {
	private int id;
	private String writer;
	private String title;
	private String context;
	private int view_cnt;
	private String reg_date;
	
	public Board() {
	}
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", writer=" + writer + ", title=" + title + ", context=" + context + ", view_cnt="
				+ view_cnt + ", reg_date=" + reg_date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
