package com.gyf.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.gyf.bos.service.IDecidedZoneService;
import com.gyf.bos.service.IFunctionSerivce;
import com.gyf.bos.service.INoticeBillService;
import com.gyf.bos.service.IRegionService;
import com.gyf.bos.service.IRoleService;
import com.gyf.bos.service.IStaffService;
import com.gyf.bos.service.ISubareaService;
import com.gyf.bos.service.IUserService;
import com.gyf.bos.service.IWorkOrderManageService;
import com.gyf.bos.utils.PageBean;
import com.gyf.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	@Autowired
	protected IDecidedZoneService decidedZoneService;
	
	@Autowired
	protected CustomerService customerService;
	
	@Autowired
	protected IRegionService regionService;
	
	@Autowired
	public IStaffService staffService;

	@Autowired
	protected ISubareaService subareaService;
	
	@Autowired
	protected IUserService userService;
	
	@Autowired
	protected INoticeBillService noticeBillService;
	
	@Autowired
	protected IWorkOrderManageService workOrderManageService;
	
	
	@Autowired
	protected IFunctionSerivce functionSerivce;
	
	@Autowired
	protected IRoleService roleService;

	private static final long serialVersionUID = 1L;
	protected T model;
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	//1.分页查询的属性
	protected PageBean pageBean = new PageBean();
	
	protected int  page = 0;
	protected int rows = 0;
	public void setPage(int page) {
		//注意这里与this.page = page的区别
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}

	public BaseAction(){
		//1.获取泛型类型
		ParameterizedType genericSuperclass = null;
		//genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		if(this.getClass().getGenericSuperclass() instanceof ParameterizedType){
			genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
			System.out.println("111111111111111");
		}else{
			genericSuperclass = (ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
			System.out.println("111111111111112");
		}
		
		
		Type[] types = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) types[0];
		
		//2.封装好查询条件,将查询条件存在PageBean中
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(dc);
		
		try {
			model = entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 
	 * @param pageBean 分页数据模型
	 * @param excludes 排版模型转json的属性
	 * @throws IOException
	 */
	protected void responseJson(Object obj,String[] excludes) throws IOException{
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=UTF-8");
		
		//将分页数据封装成固定格式的json数据
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(excludes);
		
		//重新改了下代码，更通用些
		if(obj instanceof Collection){
			JSONArray jb = JSONArray.fromObject(obj,jc);
			response.getWriter().print(jb.toString());
		}else{
			JSONObject jb = JSONObject.fromObject(obj,jc);
			response.getWriter().print(jb.toString());
		}
		
		
	}
	
	
}
