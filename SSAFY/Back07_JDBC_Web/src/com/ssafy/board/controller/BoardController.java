package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private BoardDao dao = BoardDaoImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET 요청에서는 딱히 안해도 되지만  POST 요청이 들어왔을 때 UTF-8 설정해줘야 함
		if (request.getMethod().equals("POST"))
		request.setCharacterEncoding("UTF-8");
		
		//Front_Controller 패턴
		String act = request.getParameter("act");
		
		switch (act) {
		case "list" :
			doList(request, response);
			break;
			
		default:
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", dao.selectAll());
	}
	
}
