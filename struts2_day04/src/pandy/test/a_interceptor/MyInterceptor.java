package pandy.test.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

//拦截器的第一种创建方式
//拦截器的生命周期随项目的启动而创建 随项目的关闭而销毁
public class MyInterceptor implements Interceptor {
	//销毁方法
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	//初始化方法
	public void init() {
		// TODO Auto-generated method stub
		
	}
	//核心拦截方法
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
