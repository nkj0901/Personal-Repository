<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
<h2>${requestScope.board.title }</h2>
<table>
	<tr>
		<td>id</td>
		<td>${board.id }</td>
	</tr>
	<tr>
		<td>writer</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td>content</td>
		<td>${board.context }</td>
	</tr>
	<tr>
		<td>view_cnt</td>
		<td>${board.view_cnt }</td>
	</tr>
	<tr>
		<td>reg_date</td>
		<td>${board.reg_date }</td>
	</tr>
</table>

<a href = "board?action=updateForm&id=${board.id }">수정</a>
<a href = "board?action=delete&id=${board.id }">삭제</a>
<a href = "board?action=list">목록으로 돌아가기</a>

</body>
</html>