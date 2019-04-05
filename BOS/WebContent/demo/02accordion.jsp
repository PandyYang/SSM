<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>jQuery EasyUI的accordion布局</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 100px">A</div>
	<div data-options="region:'west'" style="width: 200px">
		<!-- 1.accordion称为折叠
			 2.title标题属性一定要写
			 3.fit:true 表示自适应拉伸尺寸
		 -->
		<div class="easyui-accordion"  data-options="fit:true">
			<div title="面板一">1</div>
			<div title="面板二">2</div>
			<div title="面板二">3</div>
		</div>
	</div>
	<div data-options="region:'center'">C</div>
	<div data-options="region:'east'" style="width: 200px">D</div>
	<div data-options="region:'south'" style="height: 100px">E</div>
</body>


</html>