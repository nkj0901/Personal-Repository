package Test;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.dto.Board;

public class test {
	public static void main(String[] args) {
		BoardDaoImpl dao = BoardDaoImpl.getInstance();
		
//		System.out.println(dao.selectOne(1));
//		
//		for(Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
//		Board board = dao.selectOne(4);
//		
//		System.out.println(board);
//		board.setContext("수정수정수정");
//		
//		dao.updateBoard(board);
		
//		dao.updateViewCnt(4);
		dao.deleteBoard(4);
	}
}
