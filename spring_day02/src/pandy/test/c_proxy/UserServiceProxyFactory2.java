package pandy.test.c_proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import pandy.test.c_service.UserService;
import pandy.test.c_service.UserServiceImpl;

public class UserServiceProxyFactory2 implements Callback{
	public UserService getUserServiceProxy() {
		Enhancer en = new Enhancer();//帮我们生成代理对象
		en.setSuperclass(UserServiceImpl.class);//设置对谁进行代理
		//en.setCallback(callback);//设置代理要做什么
		
		return null;
		
	}
}
