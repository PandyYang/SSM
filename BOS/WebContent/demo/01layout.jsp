<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>jQuery EasyUI的layout布局</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>

</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 100px">A</div>
	<div data-options="region:'west'" style="width: 200px">B</div>
	<div data-options="region:'center'">C</div>
	<div data-options="region:'east'" style="width: 200px">D</div>
	<div data-options="region:'south'" style="height: 100px">E</div>
</body>

</html>