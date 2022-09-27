<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ssafy.ws.step3.dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
<style>
table, tr, td {
border-collapse:collapse; border:1px solid black;
}
</style>
</head>
<body>
	<%
		Book b = (Book)request.getAttribute("Book");
	if (b==null){
	 %>
	<h1>도서 등록 결과</h1>
	<p>등록된 도서가 없습니다.</p>
	<a href="regist.jsp">추가등록</a>
	 <%
	}
	else{
	%>
	<h1>도서 등록 결과</h1>
	<h1>등록 도서 정보</h1>
	
	<table>
	<thead align="center">
	<tr>
	<td style="width:100px; align:center">항목</td>
	<td style="width:600px; align:center">내용</td>
	</tr>
	</thead>
	<tr>
	<td>도서번호</td>
	<td><%= b.getIsbn() %></td>
	</tr>
	<tr>
	<td>도서명</td>
	<td><%= b.getTitle() %></td>
	</tr>
	<tr>
	<td>저자</td>
	<td><%= b.getAuthor() %></td>
	</tr>
	<tr>
	<td>가격</td>
	<td><%= b.getPrice() %></td>
	</tr>
	<tr>
	<td>설명</td>
	<td><%= b.getDesc() %></td>
	</tr>
	
	</table>
	<a href="regist.jsp">추가등록</a>
	<%} %>
</body>
</html>
