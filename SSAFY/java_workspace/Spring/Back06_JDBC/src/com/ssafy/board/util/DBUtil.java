package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	// mysql 드라이버 클래스 이름 (드라이버 불러오기 위해 필요)
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	// DB와 연결하기 위해 필요한 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// USER 정보
	private final String username = "ssafy";
	private final String password = "ssafy";

	// 만들어놓고 가져다가 쓰고 싶어~~ = 싱글턴
	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		// JDBC 드라이버를 로딩
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	// 커넥션을 반환하는 메서드
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	
//	//close하는 메서드 오버로딩
//	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if (pstmt != null)
//				pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if (rs != null)
//				rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void close(Connection conn, PreparedStatement pstmt) {
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if (pstmt != null)
//				pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	//...가변인자 몇개가 들어든 반복해서 처리해준다.
	public void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable ac : autoCloseables) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
