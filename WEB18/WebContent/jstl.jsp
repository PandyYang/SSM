<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.*" %>
    <!-- 使用taglib导入核心的库 -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!--jspl标签经常会和el配合使用  -->
	<%
		request.setAttribute("count", 10);
	
	%>
	<!-- el表达式从域中寻找数值，然后使用标签进行判断  -->
	<c:if test="${count==10 }">
	aaaa
	
	</c:if>
	<!-- test代表的是返回boolean的表达式条件 -->
	<!-- 使用el表达式进行解析 -->
	<c:if test="${1==1 }">
	xxxx
	
	</c:if>
	<c:if test="1!=1">
	yyyy
	
	</c:if>
	
	<c:forEach begin="0" end="5" var="i">
	${i }<br/>
	</c:forEach>
	<!-- items：一个集合或数组 var是集合中的每一项 -->
	<c:forEach items="${productList }" var="pro">
	${pro.name }
	</c:forEach>
	
	<%
	List<String> strList = new ArrayList<String>();
	strList.add("1");
	strList.add("2");
	strList.add("3");
	strList.add("4");
	request.setAttribute("strList", strList);
	%>
	<h1>取出strList中的数据</h1>
	<c:forEach items="${strList }" var="str">
	${str }<br/>
	</c:forEach>
	
	<%
		//遍历Map<String,String> 的值
		Map<String,String> strMap = new HashMap<String,String>();
		strMap.put("name", "lucy");
		strMap.put("age", "18");
		strMap.put("addr", "beiwu");
		strMap.put("email", "lucy@123.com");
		session.setAttribute("strMap", strMap);
		
		
		
		//遍历Map<String,User>中的数据
		Map<String,User> userMap = new HashMap<String,User>();
		userMap.put("user1", user1);
		userMap.put("user2", user2);
		session.putValue("userMap", userMap);
	%>
	
	<c:forEach items="strMap" var="entry">
	${entry.key }:${entry.value }<br/>
	</c:forEach>
	
	<h1>取出usermap的数据</h1>
	<c:forEach items="${userMap }" var="entry">
		${entry.key }:${entry.value.name }--${entry.value.password }
	
	</c:forEach>
	
</body>
</html>