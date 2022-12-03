<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Scope</h2>
	<%= request.getContextPath() %> <br>
	
	<%= request.getParameter("name") %> <br>
	
	<a href="/Back03_JSP/gugu.jsp">구구단</a>
</body>
</html>