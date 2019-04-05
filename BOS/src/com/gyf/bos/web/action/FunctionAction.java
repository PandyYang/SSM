package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import com.gyf.bos.domain.Function;
import com.gyf.bos.web.action.base.BaseAction;

public class FunctionAction extends BaseAction<Function>{

	public void pageQuery() throws IOException{
		//Funtion和BaseAction中都有个属性page,冲突了,先设置到model中去了
		pageBean.setCurrentPage(Integer.parseInt(model.getPage()));
		
		functionSerivce.pageQuery(pageBean);
		String[] excludes = new String[]{"roles","function","functions",
				"detachedCriteria","currentPage","pageSize"};
		responseJson(pageBean, excludes);
		
	}	
	public void jsonlist() throws IOException{
			List<Function> funs = functionSerivce.findAll();
			String[] excludes = new String[]{"roles","function","functions"};
			responseJson(funs, excludes);
	}
	
	public String add(){
		//父标题
		if(model.getFunction() != null && model.getFunction().getId().equals("")){
			model.setFunction(null);
		}
		functionSerivce.save(model);
		
		return "list";
		
	}
	
	public void findMenu() throws IOException{
		List<Function> menu = functionSerivce.findMenu();
		responseJson(menu, new String[]{"roles","functions"});
	}
}
