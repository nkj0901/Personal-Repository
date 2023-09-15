<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar date = Calendar.getInstance();
%>

<%= date.getTime() %>
<%= date.get(Calendar.YEAR) %>년
<%= date.get(Calendar.MONTH)+1 %>월
<%= date.get(Calendar.DAY_OF_MONTH) %>일 입니다.
	
</body>
</html>