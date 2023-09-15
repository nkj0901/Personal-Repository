<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>파일 업로드하기</h1>
	
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="upload_file" multiple="multiple">
		<input type="submit">
	</form>
</body>
</html>