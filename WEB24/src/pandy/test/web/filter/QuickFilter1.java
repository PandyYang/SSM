package pandy.test.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickFilter1 implements Filter{

	@Override
	//Filter对象销毁的时候，去执行destory方法
	public void destroy() {
		System.out.println("destory....");
		// TODO Auto-generated method stub
		
	}

	@Override
	//是doFilter是Filter的核心过滤方法
	/*
	 * request：代表的是请求，内部封装的是客户端的http请求的信息
	 * response：代表的是相应
	 * FilterChain：过滤链对象，就是Filter1，Filter2
	 * */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("quick1 running...");
		//放行请求
		arg2.doFilter(arg0, arg1);
	}

	@Override
	//Filter创建的时候执行这个init方法
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		arg0.getFilterName();//获得web.xml中filter 的名称
		System.out.println(arg0.getFilterName());
		
		//获得初始化的参数
		arg0.getInitParameter("aaa");//需要在web.xml之中进行相应的配置
		
		//获得servletContext
		arg0.getServletContext();//
		System.out.println("init....");
	}
	
}
