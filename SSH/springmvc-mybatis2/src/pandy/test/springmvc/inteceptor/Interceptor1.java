package pandy.test.springmvc.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("方法前1");
		//URL http://localhost:8080/springmvc-mybatis2/login.action
		//URI /login.action
		// 从usersession中获取用户名 如果登陆用户是空值的话  直接拦截 拦截之后重定向到login.action
		//要是不为空的话 直接放行
		String requestURI = request.getRequestURI();
		if(!requestURI.contains("/login")) {
			String username = (String) request.getSession().getAttribute("USER_SESSION");
			if(null==username) {
				response.sendRedirect(request.getContextPath()+"/login.action");
				return false;
			}
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("方法后1");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("页面渲染后1");
	}



}
