package pandy.test.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//拦截器的第二种创建方式
//帮我们空实现了init和destory方法  我们如果不需要实现这两个方法就可以实现 核心interceptor
public class MyInterceptor2 extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
