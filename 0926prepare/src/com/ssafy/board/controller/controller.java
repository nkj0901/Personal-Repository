package com.ssafy.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.dto.Board;

/**
 * Servlet implementation class controller
 */
@WebServlet("/board")
public class controller extends HttpServlet {
	BoardDaoImpl dao = BoardDaoImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "list" :
			doList(request, response);
			break;
		case "detail" :
			doDetail(request, response);
			break;
		case "registForm" :
			doRegistForm(request, response);
			break;
		case "regist" :
			doRegist(request, response);
			break;
		case "updateForm" :
			doUpdateForm(request, response);
			break;
		case "update" :
			doUpdate(request, response);
			break;
		case "delete" :
			doRemove(request, response);
			break;
		default:
			break;
		}
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.deleteBoard(id);
		response.sendRedirect("board?action=list");
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setId(id);
		board.setTitle(title);
		board.setContext(content);
		
		dao.updateBoard(board);
		response.sendRedirect("board?action=list");
	}

	private void doRegistForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("regist.jsp");
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Board board = new Board();
		
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContext(request.getParameter("content"));
		
		dao.insertBoard(board);
		response.sendRedirect("board?action=list");
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = dao.selectOne(Integer.parseInt(request.getParameter("id")));
			
		request.setAttribute("Board", board);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Board board = dao.selectOne(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", dao.selectAll());
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
