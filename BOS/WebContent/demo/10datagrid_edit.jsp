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

<script type="text/javascript">
	$(function () {
		$('#grid').datagrid({    
		    url:'/Bos/json/stafftest.json',    
		    columns:[[    
		        {field:'id',title:'编号',width:100,checkbox:true},    
		        {field:'name',title:'名字',width:100,
		        	editor:{
		        		type:'text',
		        		options:{}
		        	}    
		        },
		        {field:'age',title:'年龄',width:100,align:'right',
		        	editor:{
	        		type:'text',
	        		options:{}
	        	}}    
		    ]],
		    toolbar: [{
				text:'还原',
				handler: function(){
					$("#grid").datagrid("endEdit",0);
				}
			},'-',{
				text:'编辑',
				handler: function(){
					//$("#grid").datagrid("beginEdit",0);
					 $('#grid').datagrid('insertRow',{
						index: 0,	// 索引从0开始
						row: {
						}
					});
					
					$("#grid").datagrid("beginEdit",0); 

				}
			}],
			singleSelect:true,
			onAfterEdit:function(index, row, changes){
				console.info(row);
			}
		}); 
	});
</script>
js的方式渲染datagrid
<table id="grid"></table>
</body>
</html>