<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
<h1>게시글 수정하기</h1>
	<form action="board" method="POST">
	<input type="hidden" name = "action" value = "update">
	<input type="hidden" name = "id" value = "${Board.id }">
	<label for="title">제목</label>
	<input type="text" id = "title" name="title" value="${Board.title }"> 
	<label for="writer">작성자</label>
	<input type="text" id = "writer" readonly name="writer" value="${Board.writer }"> 
	<label for="content">내용</label>
	<textarea rows="10" id = "content" name="content" value="${Board.context }"></textarea> 
	
	<button>수정</button>
	</form>
</body>
</html>