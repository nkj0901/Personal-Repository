package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.dto.Board;
import com.ssafy.board.util.DButil;

public class BoardDaoImpl implements BoardDao {
	
	DButil util = DButil.getInstance();
	
	private static BoardDaoImpl instance = new BoardDaoImpl();
	
	private BoardDaoImpl() {
	}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
	//모두가져와~~
	@Override
	public List<Board> selectAll() {
		String sql = "SELECT * FROM board";
		List<Board> list = new ArrayList<Board>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContext(rs.getString("content"));
				board.setView_cnt(rs.getInt("view_cnt"));
				board.setReg_date(rs.getString("reg_date"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally { // 다 썼으면 닫아주기
			try {
				util.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Board selectOne(int id) {
		String sql = "SELECT * FROM board WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = new Board();
		
		try {
			
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			board.setId(rs.getInt("id"));
			board.setWriter(rs.getString("writer"));
			board.setTitle(rs.getString("title"));
			board.setContext(rs.getString("content"));
			board.setView_cnt(rs.getInt("view_cnt"));
			board.setReg_date(rs.getString("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				util.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		String sql = "INSERT INTO board (writer, title, content) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContext());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				util.close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateBoard(Board board) {
		String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContext());
			pstmt.setInt(3, board.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				util.close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteBoard(int id) {
		String sql = "DELETE FROM board WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				util.close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateViewCnt(int id) {
		String sql = "UPDATE board SET view_cnt = view_cnt + 1 WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				util.close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
