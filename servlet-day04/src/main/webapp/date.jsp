<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"

%>
<html>
	<head>
	</head>
	<body style="font-size:30px ;color: red;">
		今天是:
		<% Date date = new Date();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		   out.print(sdf.format(date));
		   
	
	
	%>
	
	
	</body>

</html>