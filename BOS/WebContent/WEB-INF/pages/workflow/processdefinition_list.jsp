<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程定义列表</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#grid").datagrid({
			striped : true,
			rownumbers : true,
			singleSelect : true,
			fitColumns : true,
			height:280,
			toolbar : [
				{
					id : 'deploy',
					text : '发布新流程',
					iconCls : 'icon-add',
					handler : function(){
						location.href = "${pageContext.request.contextPath}/page_workflow_processdefinition_deploy.action";
					}
				}
			]
		});
		
		$("#dlg").dialog('close');
	});
	
	
</script>	
</head>
<body class="easyui-layout">
  <div region="center" >
  	<table id="grid" class="easyui-datagrid">  
  		<thead>
  			<tr>
  				<th data-options="field:'id'" width="120">流程编号</th>
  				<th data-options="field:'name'" width="200">流程名称</th>
  				<th data-options="field:'key'" width="100">流程key</th>
  				<th data-options="field:'version'" width="80">版本号</th>
  				<th data-options="field:'viewpng'" width="200">查看流程图</th>
  			</tr>
  		</thead>
  		<tbody>
  				<s:iterator value="list" var="processDefinition">
  					<!-- 在循环过程中 ，将  processDefinition 对象，同时放入 root 和 map 中-->
  				<tr>
  					<td>
  						<s:property value="id"/> <!-- 从root找 -->
  					</td>
  					<td><s:property value="name"/></td>
  					<td><s:property value="key"/></td>
  					<td><s:property value="version"/></td>
  					<td>
  						<a onclick="showPng('${id}')"
  						 class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看流程图</a>
  						 <a onclick="del('${id}')"
  						 class="easyui-linkbutton">删除</a>
  					</td>
  					<script type="text/javascript">
						function showPng(id) {
							var url = "${pageContext.request.contextPath}/processDefinitionAction_viewpng?id=" + id;
							//在新窗口中打开流程图
							window.open(url);  
						}
						
						function del(id){
							var url = "${pageContext.request.contextPath}/processDefinitionAction_del?id=" + id;
							$.messager.confirm("确认信息","你确定要删除流程定义",function(r){
								if(r == false) return;
								$.post(url,
									function(data){
										if(data == 1){
											//删除成功
											$.messager.alert("提醒","删除成功","info",function(){
												//刷新页面
												window.location.href = "${pageContext.request.contextPath}/processDefinitionAction_list";
											});
										}else{
											//删除失败
											$.messager.alert("提醒","删除失败");
										}
									}
								);
							});
						}
</script>
  				</tr>
  				</s:iterator>
  		</tbody>
  	</table>
  </div>
  
 <div id="dlg" class="easyui-dialog" title="流程图" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px">
	</div>
  

</body>
</html>
