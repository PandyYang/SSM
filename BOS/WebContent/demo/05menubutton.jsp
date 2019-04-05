<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>



<title>Insert title here</title>
</head>
<body>
<div class="easyui-panel" style="width: 120px">
	<a href="#" class="easyui-menubutton" data-options="menu:'#mm',iconCls:'icon-ok'">更改皮肤</a>

</div>
<div id="mm" style="width:150px;">
		<div onclick="alert('default');">默认</div>
		<div >灰</div>
		<div class="menu-sep">黑</div>
</div>
</body>
</html>