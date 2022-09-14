package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	// 만들어진 dbutil 가져오기, 가져오는 순간 기본생성자에 의해 Driver가 가져와짐
	private final DBUtil util = DBUtil.getInstance();

	// 임플 바로 바로 그냥 가져오고 싶으니 싱글턴으로 만들기
	private static BoardDaoImpl instance = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		return instance;
	}

	@Override
	// 리스트 조회
	public List<Board> selectAll() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM board";
		List<Board> list = new ArrayList<>();

		try {
			// 연결
			conn = util.getConnection();
			stmt = conn.createStatement(); // 쿼리문 날릴 객체
			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 컬럼 이름을 알고 있던지 순서를 알고 있던지
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
			e.printStackTrace();
		} finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	// 상세조회
	public Board selectOne(int id) throws SQLException {
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

			while (rs.next()) {
				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegData(rs.getString(6));
			}
		} finally {
			util.close(rs, pstmt, conn);
		}
		return board;
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		// ?을 쓰면 동적으로 우리가 원하는 값을 넣을 수 있음
		String sql = "INSERT INTO board (title, writer, content) VALUES (?, ?, ?)";

		// DB 접속해서 사용하게끔 쓰자.
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			// auto커밋 해제
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			pstmt.executeUpdate();
			// 지금까지 작업한거 커밋날려라
			conn.commit();
//		} catch (Exception e) {
//			// 커밋하지마~
//			conn.rollback();
		} finally {
			util.close(pstmt, conn);
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
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
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateViewCnt(int id) {
		String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

}
