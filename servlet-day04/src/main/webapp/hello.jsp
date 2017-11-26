<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
	</head>
	<body style="font-size:30px;">
		 待我长发及腰
		 <br>
		 current time :
		 <br>
		 <%
		 	Date date = new Date(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			out.println(sdf.format(date));
		 
		 %>
	
		 <!-- 兼并表达式,相当于将等于号后面的java表达式放在out.println()的括号中输出 -->
		 current time2: <%=new Date()%>
		 <br>
		<% 
			for(int i= 0;i<100;i++){
				out.println("hello</br>");
			}
			
		%>

	
	</body>


</html>