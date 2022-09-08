<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="checkBoxResult.jsp">
		<input type="checkbox" name ="dish" value="김치전"> 김치전
		<input type="checkbox" name ="dish" value="계란말이"> 계란말이
		<input type="checkbox" name ="dish" value="연근조림"> 연근조림 <br>
		<input type="checkbox" name ="dish" value="제육볶음"> 제육볶음
		<input type="checkbox" name ="dish" value="소세지야채볶음"> 쏘야
		<input type="checkbox" name ="dish" value="삼겹살"> 삽겹살  <br>
		<input type="submit" value="구매">
	
	</form>
</body>
</html>