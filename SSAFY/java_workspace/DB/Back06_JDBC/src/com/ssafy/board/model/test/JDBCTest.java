package com.ssafy.board.model.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

// JDBC 드라이버 연결
// 데이터베이스 연결
// SQL 준비 및 실행
// 데이터베이스 연결해제

public class JDBCTest {
	
	public JDBCTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBCTest jdbctest = new JDBCTest();
		
		for (Board b : jdbctest.selectAll()) {
			System.out.println(b);
		};
	}
	
	private List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			//연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy");
			//sql 준비
			String sql = "SELECT * FROM board";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //컬럼 이름을 알고 있던지 순서를 알고 있던지
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegData(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				
				list.add(board);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn !=null)
				conn.close();
				if (rs != null)
				rs.close();
				if (stmt != null)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
