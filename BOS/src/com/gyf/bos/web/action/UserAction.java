package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.gyf.bos.domain.User;
import com.gyf.bos.utils.MD5Utils;
import com.gyf.bos.web.action.base.BaseAction;

@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private static final long serialVersionUID = 1L;

	
	public String list(){
		List<User> userList = userService.list();
		System.out.println(userList);
		return NONE;
	}
	
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	
	public String login() throws Exception{
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
	
		String checkCodeInSession = (String) request.getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkCodeInSession) && checkCodeInSession.equals(this.checkcode)){
			//1.返回当前的用户
			Subject subject = SecurityUtils.getSubject();
			
			//2.构造一个用户令牌
			String pwd = MD5Utils.md5(model.getPassword());
			String name = model.getUsername();
			AuthenticationToken token = new UsernamePasswordToken(name,pwd);
			
			try {
				//登录验证
				subject.login(token);
				//登录失败会抛出异常
			} catch (AuthenticationException  e) {
				//UnknownAccountException
				this.addActionError("用户名密码不正确");
				return "loginfailure";
			}
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return "home";
		}else{
			this.addActionError("验证码不正确");
			return "loginfailure";
		}
		
		
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	public String editPassword() throws IOException{
		
		User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		
		String newPwd = MD5Utils.md5(model.getPassword());
		
		String flag = "1";
		try {
			userService.editPassword(newPwd,loginUser.getId());
			
		} catch (Exception e) {
			flag = "0";
			e.printStackTrace();
		}
		
		//响应客户端端
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		
		return NONE;
	}
	
	public void pageQuery() throws IOException{
		userService.pageQuery(pageBean);
		String[] excludes = new String[]{"currentPage","pageSize",
				"detachedCriteria","noticeBills","roles"};
		responseJson(pageBean, excludes);
	}
	
	private String[] roleIds;//角色id
	
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	//添加用户
	public String add(){
		userService.add(model,roleIds);
		return "list";
	}
}
