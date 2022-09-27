<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
<form action="main" method="POST">
	<input type = "hidden" name = "action" value = "regist">
	<h1>SSAFY 도서 관리</h1>
	<fieldset>
	<legend>도서 등록</legend>
	<label>도서번호</label>
	<input type = "text" name = "isbn"> <br>
	<label>도서명</label>
	<input type = "text" name = "title"> <br>
	<label>저자</label>
	<input type = "text" name = "author"> <br>
	<label>가격</label>
	<input type = "text" name = "price"> <br>
	<label>설명</label> <br>
	<input style="width:700px; height:40px" type = "text" name = "desc" > <br>
	<button>등록</button>
	<button>취소</button>
	</fieldset>
	</form>
</body>
</html>