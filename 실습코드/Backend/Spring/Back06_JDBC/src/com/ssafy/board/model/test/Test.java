package com.ssafy.board.model.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

public class Test {
	public static void main(String[] args) throws SQLException {
//		BoardDao dao = BoardDaoImpl.getInstance();
		
		//Spring컨테이너 빌드
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
//		//boardDao빈 객체를 얻어와서
//		BoardDao boardDao = context.getBean("boardDao", BoardDao.class);
//		
//		//원하는 기능 호출
//		for(Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
		
		//서비스 객체를 불러오자
		BoardService boardService =  context.getBean("boardService", BoardService.class);
		
		boardService.readBoard(7);
		
		for(Board b : boardService.getBoardList()) {
		System.out.println(b);
	}
		
		
	}
}
