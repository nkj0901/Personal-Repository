<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%="HELLO" %> <br>
	<% out.print("HELLO"); %> <br>
	문자열 : ${"HELLO"}<br>
	정수형 : ${10}<br>
	실수형 : ${10.5}<br>
	논리형 : ${true}<br>
	null : ${null}<br>
</body>
</html>