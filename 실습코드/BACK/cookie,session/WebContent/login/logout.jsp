<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--<% session.removeAttribute("loginUser"); --%>
	
	<% session.invalidate(); %>
	<script type="text/javascript">
		alert("로그아웃되셨습니다.");
		location.href = "loginform.jsp"
	</script>
</body>
</html>