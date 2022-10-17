<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이곳이 mvc 처음인가</h1>
	${msg }
	
	<form action="test4" method="post">
	아이디 : <input type="text" name = "id">
	비밀번호 : <input type="password" name = "pw">
	나이 : <input type="number" name="age">
	<input type="submit">
</form>
</body>
</html>