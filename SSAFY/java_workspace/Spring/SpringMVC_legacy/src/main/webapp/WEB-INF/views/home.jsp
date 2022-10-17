<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<c:choose>
		<c:when test="${empty loginUser }">
			<a href="login">로그인</a>
		</c:when>
		<c:otherwise>
			${loginUser }님 반갑습니다.
		</c:otherwise>
	</c:choose>

	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
