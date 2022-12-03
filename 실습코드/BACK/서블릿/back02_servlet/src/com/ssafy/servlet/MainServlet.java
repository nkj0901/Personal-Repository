package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Person;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");	
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
			
			default:
				//아무 것도 아닐 때 처리해줘
				break;
		}
	}
	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		Person p = new Person(name, age, gender, hobbies);
		
		PrintWriter writer = response.getWriter();
		
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>PersonInfo</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h1>등록한 사람 정보</h1>");
		writer.append(p.toString());
		writer.append("</body>");
		writer.append("</html>");
	}
}
