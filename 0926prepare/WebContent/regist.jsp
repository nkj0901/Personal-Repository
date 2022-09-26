<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
</head>
<body>
	<h1>게시글 등록하기</h1>
	<form action="board" method="POST">
	<input type="hidden" name = "action" value = "regist">
	<label for="title">제목</label>
	<input type="text" id = "title" name="title"> 
	<label for="writer">작성자</label>
	<input type="text" id = "writer" name="writer"> 
	<label for="content">내용</label>
	<textarea rows="10" id = "content" name="content"></textarea> 
	
	<button>등록</button>
	</form>
</body>
</html>