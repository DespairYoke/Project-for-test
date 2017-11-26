<%@page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>页面向控制器传递参数</h1>
		<form action="demo/test.do" method="post">
			<div>
				<label>年龄</label>
				<input type="text" name="age">
			</div>
			<div>
				<label>地址</label>
				<input type="text" name="address">
			</div> 
			<div>
				<label>价格</label>
				<input type="text" name="price">
 			</div>
			<input type="submit" value="提交">
		</form>
	</body>
</html>





