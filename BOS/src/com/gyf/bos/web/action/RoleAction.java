package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import com.gyf.bos.domain.Role;
import com.gyf.bos.web.action.base.BaseAction;

public class RoleAction extends BaseAction<Role>{

	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	//添加角色
	public String add(){
		roleService.save(model,ids);
		return "list";
	}
	
	public void pageQuery() throws IOException{
		roleService.pageQuery(pageBean);
		responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","users","functions"});
	}
	
	public void jsonlist() throws IOException{
		List<Role> list = roleService.findAll();
		responseJson(list, new String[]{"users","functions"});
	}
}
