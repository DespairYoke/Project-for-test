<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<% Cookie[] cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			String name=cookies[i].getName();
			String value=cookies[i].getValue();
			out.println("name:"+name+"  value:"+value);
		}
	}%>
</body>
</html>