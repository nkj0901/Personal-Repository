<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인하기</h1>
	<form action="person" method="post">
		<input type="hidden" name="action" value="login">
		<input type="text" name="id" placeholder="아이디입력">
		<input type="password" name="pw" placeholder="비밀번호입력">
		<button type="submit">로그인</button>
	</form>
</body>
</html>