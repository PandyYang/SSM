<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messager</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/* 	页面加载完成之后执行
	它其实是$(document).ready(function(){
		
	}) 的简写形式*/
	$(function(){
		//alert方法---提示框 以下的方法其实也是简写形式 其实是window.alert()方法
		//alert(1111);
		//$.messager.alert("标题","内容","error");
		
		
		//confirm方法 标题内容  回调函数
	/* 	$.messager.confirm("提示信息","你确定要删除当前记录吗？",function(r){
			alert(r);
		}); */
		//----show方法
		$.messager.show({
			title:"欢迎信息",
			msg:"欢迎【admin】登录系统",
			timeout:"5000",
			showType:"slide"
		});
		
	});
</script>
</head>
<body>
	
</body>
</html>