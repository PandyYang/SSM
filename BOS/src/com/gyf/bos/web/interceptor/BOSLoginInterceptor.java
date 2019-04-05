package com.gyf.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.gyf.bos.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		/*User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if(loginUser == null){
			//未登录过
			return "login";
		}*/
		//已经登录，放行
		return invocation.invoke();
	}
}
