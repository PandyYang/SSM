<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Demo11Action" method ="post">
	list:<input type="text" name="list"/><br>
	list:<input type="text" name = "list[3]">
	map:<input type="text" name = "map['hehe']">
			
	<input type="submit" value="提交">
	</form>
</body>
</html>