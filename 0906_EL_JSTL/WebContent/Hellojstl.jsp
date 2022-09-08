 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="Hello SSAFY"/> <br>
	
	<%-- scope : 어디영역에다가 해당 변수를 선언할 건지
		 var : 변수이름
		 value : 값 --%>
	<c:set var="msg" value="hello1"></c:set> 
	${msg} <br>
	
	<!-- 태그 안에 넣어도 value로 인식된다. -->
	<c:set var="msg2">hello</c:set>
	${msg2} <br>

</body>
</html>