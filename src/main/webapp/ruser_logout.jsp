<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그아웃 할 경우 세션을 끊고 main 페이지로 redirect 해줌 -->
<% session.invalidate(); 
   response.sendRedirect("main.jsp");
%>
</body>
</html>