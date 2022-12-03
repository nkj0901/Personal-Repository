package com.ssafy.person.survlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.person.dto.Person;
import com.ssafy.person.manager.PersonManager;

/**
 * Servlet implementation class PersonSurvlet
 */
@WebServlet("/person")
public class PersonSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonManager manager = PersonManager.getManager();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//action에 따라 준비되도록 switch - case 만들고
		//해당 요청들을 처리할 함수들을 정의해놓자
		String action = request.getParameter("action");
		
		switch(action) {
		case "login" :
			doLogin(request, response);
			break;
		case "getList" : 
			doGetList(request, response);
			break;
		case "getDetail" :
			doGetDetail(request, response);
			break;
		case "addPerson" :
			doAddPerson(request, response);
			break;
		case "updatePerson" :
			doUpdatePerson(request, response);
			break;
		case "deletePerson" :
			doDeletePerson(request, response);
			break;
		case "updateForm" :
			doUpdateForm(request, response);
		default : 
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response); 
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (id.equals("ssafy") && pw.equals("1234")) {
			request.getSession().setAttribute("id", id);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("main.jsp");
		}
		
	}
	
	private void doAddPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		Person p = new Person(no, name, age, msg);
		
		manager.addPerson(p);
		response.sendRedirect("person?action=getDetail&no=" + no);
	}
	
	private void doGetDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int no = Integer.parseInt(request.getParameter("no"));		
		Person p = manager.getPerson(no);
		
		request.setAttribute("person", p);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	
	private void doGetList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("personList", manager.getList());
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
		
	private void doUpdatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		Person p = new Person(no, name, age, msg);
		
		manager.updatePerson(p);
		response.sendRedirect("person?action=getDetail&no="+no);	
	}

	private void doDeletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		manager.deletePerson(no);
		
		response.sendRedirect("person?action=getList"); //서버가 클라이언트에게 주는 것
	}
}
