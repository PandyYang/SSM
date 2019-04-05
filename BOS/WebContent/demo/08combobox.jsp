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
<!-- 加个语言包，显示中文  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>Insert title here</title>
<body>

</body>
<!-- 普通的easyui-combobox使用 -->
<!-- <select class="easyui-combobox" >
	<option value='1'>北京</option>
	<option>上海</option>
	<option>广州</option>
	<option>深圳</option>
</select> -->

<input  class="easyui-combobox"  style="width:100px;" 
		data-options="
		url:'${pageContext.request.contextPath}/json/combobox.json',
		valueField:'id',
		textField:'privince',
		mode:'remote'"/>
</html>