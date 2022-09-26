<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<table>
		<tr>
			<th>id</th>
			<th>writer</th>
			<th>title</th>
			<th>view_cnt</th>
			<th>reg_date</th>
		</tr>

		<c:forEach var="board" items="${requestScope.list }">
			<tr>
				<th>${board.id }</th>
				<th>${board.writer }</th>
				<th>
				<a href = "board?action=detail&id=${board.id }">${board.title }</a>
				</th>
				<th>${board.view_cnt }</th>
				<th>${board.reg_date }</th>
			</tr>
		</c:forEach>
	</table>
	<a href = "board?action=registForm">등록하러가기</a>
</body>
</html>