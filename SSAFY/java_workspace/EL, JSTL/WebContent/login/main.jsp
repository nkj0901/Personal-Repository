<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("loginform.jsp");
		}else{
			%>
			<%=session.getAttribute("loginUser")%>님 안녕하세요.
			<%
		}
	%>
	<form action="logout.jsp" method = "post">
		<button>로그아웃</button>
	</form>
	
	<h3>메인 페이지 입니다.</h3>
</body>
</html>