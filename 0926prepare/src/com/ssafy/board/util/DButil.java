package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	private static DButil instance = new DButil();
	
	public static DButil getInstance() {
		return instance;
	}
	
	//연결할 드라이버 위치
	private String driverName = "com.mysql.cj.jdbc.Driver";
	
	//DB 연결할 때 필요한 URL,유저네임,비밀번호
	private String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	private String userName = "ssafy";
	private String passWord = "ssafy";
	
	//드라이버 로딩
	private DButil() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userName, passWord);
	}
	
	public void close(AutoCloseable... autoCloseables) throws Exception {
		for (AutoCloseable as : autoCloseables) {
			if(as != null) {
				as.close();
			}
		}
		
	}
}
