package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gyf.bos.domain.WorkOrderManage;
import com.gyf.bos.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class WorkOrderManageAction extends BaseAction<WorkOrderManage>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add() throws IOException{
		workOrderManageService.save(model);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("1");
	}
	
	public String list(){
		//查询状态为0的工作单 
		List<WorkOrderManage> list = workOrderManageService.findListNoStart();
		ActionContext.getContext().getValueStack().set("list", list);
		return "list";
	}
	
	public String start(){
		//启动流程实例
		workOrderManageService.start(model.getId());
		return list();
	}
}
