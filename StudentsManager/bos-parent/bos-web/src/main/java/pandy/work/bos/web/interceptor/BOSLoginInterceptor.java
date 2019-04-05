package pandy.work.bos.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import pandy.work.bos.domain.User;
import pandy.work.bos.utils.BOSUtils;

/**
 * 自定义拦截器实现用户未登陆自动跳转到登录页面
 * @author Pandy
 *	2018年10月23日
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//从session中获取用户对象
		User user = BOSUtils.getLoginUser();
		if(user==null) {
			//没有登陆的话跳转到主界面
			return "login";
		}
		//否则的话放行
		return invocation.invoke();
	}
	
}
