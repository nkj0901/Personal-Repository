<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<!-- 이것은 HTML 주석입니다 -->
<%--이것은 JSP 주석입니다 --%>
<h1>구구단</h1>
<%
	for (int dan = 2; dan <=9; dan++){
		for (int i = 1; i <=9; i++){
			out.print(dan + " * " + i + " = " + (dan*i));
			//out.print("<br>");
			%>
			<br>
			<%  
		}
	}
%>
</body>
</html>