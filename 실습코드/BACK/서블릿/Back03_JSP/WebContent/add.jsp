<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    int global = 1; 
    int num1 = 10, num2 = 20;
   
    public int add(int a, int b){
    	return a+b;
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD</title>
</head>
<body>
<h1>더하기를 해보자.</h1>
<% 
	int local = 1;
	out.print(add(num1, num2));
	
	out.print("글로벌 ");
	out.print(global++);
	out.print("로컬 ");
	out.print(local++);
%>

</body>
</html>