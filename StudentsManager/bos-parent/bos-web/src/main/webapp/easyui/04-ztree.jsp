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
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
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
			  
			  <div title="面板二">
			  <!--  展示ztree的效果 使用标准的json数据构造ztree-->
			  <ul id="ztree1" class="ztree"></ul>
			  <script type="text/javascript">
			  	$(function(){
			  		//页面加载完成之后 执行这段代码 动态创建ztree
			  		var setting={};
			  		//构造节点数据
			  		var zNodes = [
					  			{"name":"节点1","children":[
					  				                        {"name":"节点1——1"}, 
					  				                      	{"name":"节点1——2"}, 
					  				                    	{"name":"节点1——3"}
					  										]},//每个json对象表示一个节点数据
					  			{"name":"节点2"},
					  			{"name":"节点3"}
			  					  ];
			  			//节点构造完成之后  调用API初始化ztree 之后这棵树出现
			  		$.fn.zTree.init($("#ztree1"), setting, zNodes);
			  	});
			  </script>
			  
			  
			  
			  </div>
			  <div title="面板三">
			  <!--  展示ztree的效果 使用标准的json数据构造ztree-->
			  <ul id="ztree2" class="ztree"></ul>
			  <script type="text/javascript">
			  	$(function(){
			  		//页面加载完成之后 执行这段代码 动态创建ztree
			  		var setting2={
			  				data: {
			  					simpleData: {
			  						enable: true//使用简单json去构造ztree节点
			  					}
			  		
			  				}
			  				
			  		};
			  		//构造节点数据
			  		var zNodes2 = [
					  			{"id":"1","pId":"0","name":"节点1"},
					  			{"id":"2","pId":"1","name":"节点2"},
					  			{"id":"3","pId":"2","name":"节点3"}
			  					  ];
			  			//节点构造完成之后  调用API初始化ztree 之后这棵树出现
			  		$.fn.zTree.init($("#ztree2"), setting2, zNodes2);
			  	});
			  </script>
					
					
			  </div>
			  <div title="面板四">
			   <!--发送ajax请求来获取json数据构造ztree-->
			  <ul id="ztree4" class="ztree"></ul>
			  <script type="text/javascript">
			  	$(function(){
			  		//页面加载完成之后 执行这段代码 动态创建ztree
			  		var setting4={
			  				data: {
			  					simpleData: {
			  						enable: true//使用简单json去构造ztree节点
			  					}
			  		
			  				},
					   	 	callback: {
					  			//为ztree节点绑定单击事件
					  			onClick: function(event, treeId, treeNode){
					  				
					  				if(treeNode.page!=undefined){
					  				//判断选项卡是否已经存在
					  				var e = $("#mytabs").tabs("exists",treeNode.name);
					  				if(e){
					  					//已经存在的话 选中
					  					$("#mytabs").tabs("select",treeNode.name);
					  				}else{
					  					
					  				//动态添加一个选项卡
					  				$("#mytabs").tabs("add",{
					  					title:treeNode.name,
					  					closable:true,
					  					content:'<iframe frameborder="0" height="100%" width="100%" src="'+treeNode.page+'"></iframe>'
					  				});
					  				}
					  				
					  				}
					  			}
					  		}
			  				 
			  		};
			  		//构造节点数据
			  		/* var zNodes2 = [
					  			{"id":"1","pId":"0","name":"节点1"},
					  			{"id":"2","pId":"1","name":"节点2"},
					  			{"id":"3","pId":"2","name":"节点3"}
			  					  ]; */
			  			//节点构造完成之后  调用API初始化ztree 之后这棵树出现
			  			
			  		//发送ajax请求获取json数据
			  		//jquery提供的ajax方法：ajax post get load getJSON getScript
			  	
			  		var url = "${pageContext.request.contextPath}/json/menu.json";
			  		$.post(url,{},function(data){
			  			//在ajax获取到data之后 我们使用ztree的api进行初始化 从中获取到json数据进行解析
				  		$.fn.zTree.init($("#ztree4"), setting4, data);
			  			
			  		},'json');
			  		
			  	});
			  </script>
			  
			  </div>
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