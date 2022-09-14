package com.ssafy.board.model.test;

import java.sql.SQLException;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) throws SQLException {
		BoardDao dao = BoardDaoImpl.getInstance();

//		Board board = new Board("안녕", "임영산", "보고싶어");
//		
//		try {
//			dao.insertBoard(board);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		dao.updateViewCnt(2);
		
		Board board = dao.selectOne(2);
		board.setContent("hi");
		dao.updateBoard(board);
		
		for(Board b : dao.selectAll()) {
			System.out.println(b);
			
		}
		
//		System.out.println(dao.selectOne(1));
		
//		dao.deleteBoard(3);
	}
}
