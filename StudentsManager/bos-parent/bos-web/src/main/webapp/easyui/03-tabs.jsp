<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tabs</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<!--  使用div元素描述每个区域-->
	<div title="xxx管理系统" style="height: 100px" data-options="region:'north'">北部区域</div>
	<div title="菜单" style="width: 200px" data-options="region:'west'">
		<!--  制作accordion折叠面板
			fit:true：填充父容器
		-->
		<div class="easyui-accordion" data-options="fit:true">
			<!--  使用子div来表示每个面板-->
			  <div data-options="iconCls:'icon-cut'" title="面板一">
			  	<a id="but1" class ="easyui-linkbutton">添加一个选项卡</a>
			 
			  	<script type="text/javascript">
			  		$(function(){
			  			//页面加载完之后才执行 为上面的按钮绑定事件
			  			//但是注意function({})是一种立即执行的函数
			  			$("#but1").click(function(){
			  				//alert();
			  				
			  				//判断系统管理选项卡是否存在 通过标题进行区分
			  				var e = $("#mytabs").tabs("exists","系统管理");
			  				
			  				if(e){
			  					//已经存在  选中就可以
			  					$("#mytabs").tabs("select","系统管理");
			  				}else{
			  					$("#mytabs").tabs("add",{
				  					title:'系统管理',
				  					iconCls:'icon-edit',
				  					closable:'true',
				  					content:'<iframe frameborder="0" height="100%" width="100%" src="http://www.baidu.com"></iframe>'
				  				});
			  				}
			  			});
			  		});
			  	</script>
			  </div>
			  
			  <div title="面板二">222</div>
			  <div title="面板三">333</div>
		</div>    
	
	</div>
	<div data-options="region:'center'">
		<div id="mytabs" class="easyui-tabs" data-options="fit:true">
			<div data-options="iconCls:'icon-edit'" title="页面一">111</div>
			<div data-options="closable:true" title="页面二">222</div>
			<div data-options="iconCls:'icon-edit'" title="页面三">333</div>
		
		</div>
	
	</div>
	<div style="width: 100px" data-options="region:'east'">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>