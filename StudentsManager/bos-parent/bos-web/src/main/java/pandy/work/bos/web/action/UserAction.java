package pandy.work.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pandy.work.bos.domain.User;
import pandy.work.bos.service.IUserService;
import pandy.work.bos.utils.BOSUtils;
import pandy.work.bos.web.action.base.BaseAction;
/**
 * @author Pandy
 *	2018年10月23日
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//页面输入的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Autowired
	private IUserService userService;
	/*
	 * 实现用户登录的功能
	 * */
	public String login() {
		//从session 中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {
			//输入的验证码正确
			User user = userService.login(model);
			if(user!=null) {
				//表示数据库中有相应的值  登录成功
				//将user对象放到session域中 然后跳转到首页
				ServletActionContext.getRequest().getSession().setAttribute("loginUser",user);
				return HOME;
			}else {
				//登录失败 设置提示信息  跳转页面
				this.addActionError("用户名或者密码错误");
				return LOGIN;
			}
		}else {
			//输入的验证码错误 设置提示信息  跳转到登录的页面
			this.addActionError("输入的验证码错误");
			return LOGIN;
			
		}
	}
	/*
	 * 用户注销功能
	 *销毁session 然后跳转到一个页面
	 * */
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	
	/*
	 * 修改当前用户的密码
	 * */
	
	public String editPassword() throws IOException {
		String f="1";
		//获取当前登录用户
		User user = BOSUtils.getLoginUser();
		try{
			//password是前台传入的  id是后台数据库读取的
			userService.editPassword(user.getId(),model.getPassword());
		}catch(Exception e){
			f="0";
			e.printStackTrace();
		}
		//向前台写数据 获取当前页的响应 然后像前台的路径中写入 回传参数
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
}

