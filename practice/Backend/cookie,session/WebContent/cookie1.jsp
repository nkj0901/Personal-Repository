<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>���� �� ������ �ȿ� �ִ� ��Ű����</h2>
	<hr>
	<%	//��Ű�迭�� ������
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
			out.print("������ ��Ű�� ����.");
		}
	%>

	<h2>��Ű����</h2>
	<form action="make" method = "get">
	�̸� : <input type = "text" name = "key"> <br>
	�� : <input type = "text" name = "value"> <br>
	<input type = "submit" value = "��Ű����">
	</form>
</body>
</html>