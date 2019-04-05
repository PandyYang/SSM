<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ztree</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<!--  将静态的的html渲染为datagrid样式-->
	<table class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">年龄</th>
			</tr>
		</thead>
	</table>
	<hr>
	<!--  方式二:发送ajax请求 获取json数据创建datagrid-->
	<table data-options="url:'${pageContext.request.contextPath }/json/datagrid_data.json'" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">年龄</th>
			</tr>
		
		</thead>
	</table>
	<hr>
	<!--  方式二:-->
	<table id="mytable">
	</table>
	<script type="text/javascript">
		$(function(){
			//页面加载完成后 创建数据表格datagrid
			$("#mytable").datagrid({
				//定义标题行所有的列
				columns:[[
							{title:'编号',field:'id',checkbox:true},
							{title:'姓名',field:'name'},
							{title:'年龄',field:'age'},
							{title:'地址',field:'address'}
					
						]],
						url:'${pageContext.request.contextPath }/json/datagrid_data.json',
						rownumbers:true,
						singleSelect:true,
						toolbar:[
							{text:'添加',iconCls:'icon-add',handler:function(){
								//为按钮绑定单击事件
								alert('add...')
								}
							},
							{text:'删除',iconCls:'icon-remove'},
							{text:'修改',iconCls:'icon-edit'},
							{text:'查询',iconCls:'icon-search'}	
				 		],
						//分页条
						pagination:true			
			});
		});
	</script>
	
</body>
</html>