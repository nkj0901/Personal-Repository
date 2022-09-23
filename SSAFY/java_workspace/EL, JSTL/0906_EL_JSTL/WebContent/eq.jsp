<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.id }<br>
==: <%=request.getParameter("id")=="yang" %> <br>
equals() : <%= request.getParameter("id").equals("yang") %><br>
<%-- 쿼리스트링 넣어서 확인해보기  ex) ?id=yang --%>

== : ${param.id == "yang"}<br>
</body>
</html>