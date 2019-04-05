package pandy.test.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import pandy.test.c_service.UserService;
import pandy.test.c_service.UserServiceImpl;

public class UserServiceProxyFactory implements InvocationHandler{
	
	public UserServiceProxyFactory(UserService us) {
		super();//代表实例的父类
		this.us = us;
	}

	private UserService us;
	public UserService getUserServiceProxy() {
		//生成动态代理
		UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(), UserServiceImpl.class.getInterfaces(),this );
		//返回
		return usProxy;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("打开事务");
		Object invoke = method.invoke(us, args);//业务方法的执行
		System.out.println("提交事务");
		return invoke;
	}
}
