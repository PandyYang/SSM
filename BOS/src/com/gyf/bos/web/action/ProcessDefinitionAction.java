package com.gyf.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageWriter;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ProcessDefinitionAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositoryService rs;
	public String list(){
		//查询流程定义
		ProcessDefinitionQuery query = rs.createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();
		
		//压栈
		ActionContext.getContext().getValueStack().set("list", list);
		return "list";
	}
	
	private File zipFile;
	
	public void setZipFile(File zipFile) {
		this.zipFile = zipFile;
	}

	//部署流程定义
	public String deploy() throws FileNotFoundException{
		DeploymentBuilder db = rs.createDeployment();
		db.addZipInputStream(new ZipInputStream(new FileInputStream(zipFile)));
		db.deploy();
		return list();
	}
	
	
	private String id;
	public void setId(String id) {
		this.id = id;
	}

	public void del() throws IOException {
		
		String del = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//根据ID获取流程定义
		ProcessDefinitionQuery query = rs.createProcessDefinitionQuery();
		query.processDefinitionId(id);
		ProcessDefinition pd = query.singleResult();
		try {
			rs.deleteDeployment(pd.getDeploymentId());
			del = "1";
			response.getWriter().write(del);
		} catch (RuntimeException  e) {
			response.getWriter().write(del);
		}
	}
	
	public String viewpng(){
		//1.根据ID获取流程图
		InputStream is = rs.getProcessDiagram(id);
		ActionContext.getContext().getValueStack().set("imgIS", is);
		return "viewpng";
	}
}
