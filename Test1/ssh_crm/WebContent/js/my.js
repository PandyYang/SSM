
	//使用ajax加载数据字典生成select
	//参数1：数据字典类型
	//参数2：将下拉选放入标签id
	//参数3：生成下拉选时 select标签的name属性
	//参数4：需要回显时 选中哪个option
	function loadSelect(typecode,positionId,selectname,selectedId){
		//创建select对象 将name属性指定出来 jqery前面加上$符号表示规范
		var $select = $("<select name ="+selectname+"></select>")
		//添加提示选项
		//$<"<option value=''>-------------请选择-------------</option>">
		$select.append($("<option value=''>------请选择------</option>"));
		//使用jquery的ajax方法进行访问后台的action
		$.post("${pageContext.request.contextPath}/BaseDictAction", {dict_type_code:typecode},
		  function(data){
		    //alert(data);
		    //遍历
		    $.each( data, function(i, json){
		    	 var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
		    	 if(json['dict_id']==selectedId){
		    		 //判断是否需要回显 如果需要使其被选中
		    		 $option.attr("selected","delected");
		    	 }
		    	 
		    	 $select.append($option);
		    	 
		    	});
		  },type="json");
		//返回一个json数组对象对其进行遍历
			//每次遍历创建一个option对象 并添加到select对象 判断是否需要回显
			
		//将组装好的select对象放入页面的指定位置
		
		$("#"+positionId).append($select);
		
		
	}