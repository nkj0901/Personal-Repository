<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<%-- <a href="/mvc/file/${fileName }">${fileName }</a> --%>
	
	<a href="download?fileName=${fileName }">${fileName }</a>
</body>
</html>