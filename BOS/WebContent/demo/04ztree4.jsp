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

<!-- ztree -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.all.js"></script>

<script type="text/javascript">
	var index = 1;
	function addTab() {
		$('#tt').tabs('add',{
			title: '收单列表'+index,
			content: '<div >Content'+index+'</div>',
			closable: true
		});
		index++;
	}
	
	$(function() {
		var selectedId = 0;
		//1.节点配置
		var setting = {
			data: {
				simpleData: {
					enable: true//使用简单树形json数据
				}
			},
			callback:{
				onClick:function(event, treeId, treeNode){
					/* 在内容中添加tabbar */
					//获取tabs中是否存在当前要展开的内容
					
					if(!treeNode.isParent){
						var tab = $("#tt").tabs("exists",treeNode.name);
						if(tab){
							//如果已经存在tabs中了，就打开选中
							$("#tt").tabs("select",treeNode.name);
						}else{
							$('#tt').tabs('add',{
								title: treeNode.name,
								content: '<div >Content测试</div>',
								closable: true
							});
						}
						
					}
				}
			}
		};
		
		//2.通过发送网络请求来获取树型菜单的数据
		var url = "${pageContext.request.contextPath}/json/menu.json"
		/* 1.post网络请求最后一个参数为dataType
		   2.可选。规定预期的服务器响应的数据类型。
			默认执行智能判断（xml、json、script 或 html）*/
		$.post(url,function(data){
			//3.初始化节点内容
			$.fn.zTree.init($("#tree"), setting, data);
		},"json");
		
	});
</script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 100px">A</div>
	<div data-options="region:'west'" style="width: 200px">
		<!-- 1.accordion称为折叠
			 2.title标题属性一定要写
			 3.fit:true 表示自适应拉伸尺寸
		 -->
		<div class="easyui-accordion"  data-options="fit:true">
			<div title="面板一"><a href="javascript:void(0)" onclick="addTab()">收单列表</a></div>
			<div title="ztree">
				<ul id="tree" class="ztree" style="width:150px; overflow:auto;"></ul>
			</div>
			<div title="面板二">3</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tt" class="easyui-tabs" data-options="fit:true" >
			<!--  closable:true：表示显示关闭按钮 -->
			<div title="快递列表" data-options="closable:true">快递列表</div>
		</div>
	</div>
	<div data-options="region:'east'" style="width: 200px">D</div>
	<div data-options="region:'south'" style="height: 100px">E</div>
</body>


</html>