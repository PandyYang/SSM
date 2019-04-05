<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ocupload-1.1.2.js"></script>

<title>Insert title here</title>
</head>
<body>
<form action="abc" target="myiframe">
	<input type="file" name="excelFile">
	<input type="submit">
</form>
<!-- 
1.为了让上传后，不跳转到其它页面，可以在当前页添加一个ifame来显示服务器的返回数据
2.为了用户体验好点，可以把iframe的宽高设置为0-->
<iframe name="myiframe" style="width: 0;height: 0"></iframe>

<br>

<input type="button" id="excel_upload_btn" value="上传文件"/>
<script type="text/javascript">
	$(function () {
		$("#excel_upload_btn").upload({
			action:"abc",
			name:"excelFile",
			onSubmit:function(){
				alert("提交上传了");
			}
		});
	});
</script>
</body>


</html>