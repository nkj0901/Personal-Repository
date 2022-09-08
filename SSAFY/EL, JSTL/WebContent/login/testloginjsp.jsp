<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String id = request.getParameter("id");	

	//자바코드만 쓰겠다.
	if (id.equals("ssafy") && request.getParameter("password").equals("1234")){
		//로그인 성공
		session.setAttribute("loginUser", id);
		response.sendRedirect("main.jsp");
		
	} else {
		//로그인 실패
		 response.sendRedirect("loginform.jsp");
	}
	
%>