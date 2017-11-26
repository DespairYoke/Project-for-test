<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@page import="java.util.Date" %>
    <%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!Date date=new Date();
	SimpleDateFormat sdf;%>
	<h1>当前系统时间:<h1><%=new SimpleDateFormat("yyyy-MM-dd").format(date)%>
</body>
</html>