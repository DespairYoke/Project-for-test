<%@page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head></head>
	<body>
		<!-- /WEB-INF/jsp/list.jsp -->
		<h1>产品列表</h1>
		<ul>
			<c:forEach var="p" items="${list}">
				<li>${p.address} ${p.age}</li>
			</c:forEach>
		</ul>
	</body>
</html>
