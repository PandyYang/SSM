<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/el/form2.jsp" method="get">
		<input type="text" name="username"><br>
		<input type="password" name="password"><br>
		<input type="submit" value="提交"><br>
	
	</form>
	<!-- 获得表单的参数 -->
	<%
		request.getParameter("username");
		//...
	%>
	
	<!-- 使用el获得参数 -->
	
	${param.username }
	<!-- 取头文件 -->
<%-- 	${header.Host } --%>
	${header["User-Agent"] }
	
	${initParam.aaa }
	${cookie.name.value }
	
	
	<!-- 通过el表达式获得request对象 -->
	${pageContext.request.contextPath }
</body>
</html>