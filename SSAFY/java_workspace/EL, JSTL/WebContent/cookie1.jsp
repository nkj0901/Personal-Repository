<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>현재 내 브라우저 안에 있는 쿠키정보</h2>
	<hr>
	<%	//쿠키배열로 가져옴
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (Cookie c : cookies){
				String key = c.getName();
				String value = c.getValue();
				%>
				<h3><%=key %> : <%=value %></h3>
				<% 
			}
		} else{
			out.print("설정된 쿠키가 없다.");
		}
	%>

	<h2>쿠키설정</h2>
	<form action="make" method = "get">
	이름 : <input type = "text" name = "key"> <br>
	값 : <input type = "text" name = "value"> <br>
	<input type = "submit" value = "쿠키생성">
	</form>
</body>
</html>