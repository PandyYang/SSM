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
</head>
<body>
静态方式渲染的datagrid
<table class="easyui-datagrid" width="300px">
	<thead>
		<tr>
			<!--  参照datagrid/basic.html源码，需要设置data-options -->
			<th data-options="field:'id'">编号</th>
			<th data-options="field:'name'">姓名</th>
			<th data-options="field:'age'">年龄</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>01</td>
			<td>李四</td>
			<td>20</td>
		</tr>
		<tr>
			<td>02</td>
			<td>张三</td>
			<td>20</td>
		</tr>
	</tbody>
</table>

Ajax方式渲染的datagrid
<!-- 1.只需要的data-options里配置个url的路径
     2.这个url返回的数据需要json格式的一个数组
     3.easyui会自动发送网络请求渲染datagrid -->
<table class="easyui-datagrid" width="300px" data-options="url:'/Bos/json/stafftest.json'">
	<thead>
		<tr>
			<th data-options="field:'id'">编号</th>
			<th data-options="field:'name'">姓名</th>
			<th data-options="field:'age'">年龄</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
	$(function () {
		$('#grid').datagrid({    
		    url:'/Bos/json/stafftest.json',    
		    columns:[[    
		        {field:'id',title:'编号',width:100,checkbox:true},    
		        {field:'name',title:'名字',width:100},    
		        {field:'age',title:'年龄',width:100,align:'right'}    
		    ]],
		    toolbar: [{
				iconCls: 'icon-edit',
				text:'Edit',
				handler: function(){alert('编辑按钮')}
			},'-',{
				iconCls: 'icon-help',
				text:'Help',
				handler: function(){alert('帮助按钮')}
			},'-',{
				text:'删除',
				handler: function(){}
			},'-',{
				text:'修改',
				handler: function(){}
			}],
			//singleSelect:true
			pagination:true,
			pageSize:3,
			pageList:[3,5,7]
		}); 
	});
</script>
js的方式渲染datagrid
<table id="grid"></table>
</body>
</html>