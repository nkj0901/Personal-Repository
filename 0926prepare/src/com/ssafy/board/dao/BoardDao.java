package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.dto.Board;

public interface BoardDao {
	
	//모두보기
	public List<Board> selectAll();
	//해당아이디를 가진 애만 자세히 보기
	public Board selectOne(int id);
	//게시글 등록
	public void insertBoard(Board board);
	//게시글 수정
	public void updateBoard(Board board);
	//게시글 삭제
	public void deleteBoard(int id);
	//조회수 증가
	public void updateViewCnt(int id);
}
