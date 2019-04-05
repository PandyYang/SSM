package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gyf.bos.domain.Staff;
import com.gyf.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String add(){
		staffService.save(model);
		return "list";
	}
	
	

	public void pageQuery() throws Exception {
		//2通过service查询分页数据
		if(staffService == null){
			System.out.println("staffService == null");
		}
		staffService.pageQuery(pageBean);
		responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria"});
	}
	
	
	
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}


	public String delete(){
		staffService.deleteBatch(ids);
		return NONE;
	}
	
	//@RequiresPermissions(value="staff")
	public String edit(){
		
		Subject subject = SecurityUtils.getSubject();
		subject.checkPermission("staff");
		
		//因为不是所有字段都要修改的，所以从数据库获取一个持久化字段较好
		Staff staff = staffService.findById(model.getId());//持久化对象
		
		//需要更新的字段
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStation(model.getStation());
		staff.setStandard(model.getStandard());
		
		//执行更新
		staffService.update(staff);
		return "list";
	}
	
	public void listjson() throws IOException{
		//查找在职员工
		List<Staff> list = staffService.findListNotDelete();
		responseJson(list, new String[]{"decidedZones"});
	}
}
