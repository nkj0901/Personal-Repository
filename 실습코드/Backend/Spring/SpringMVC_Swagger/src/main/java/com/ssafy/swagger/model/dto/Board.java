package com.ssafy.swagger.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardDTO", description = "게시글 정보를 표현")
public class Board {
	
	@ApiModelProperty(value = "게시글 고유 번호", example = "10")
	private int id;
	private String writer;
	private String title;
	private String content;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int id, String writer, String title, String content) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}

}
