package pandy.test.c_proxy;

import org.junit.Test;

import pandy.test.c_service.UserService;
import pandy.test.c_service.UserServiceImpl;

public class Demo {
	@Test
	public void fun1() {
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
	}
	@Test
	public void fun2() {
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.delete();
	}
	@Test
	public void fun3() {
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.update();
	}
	@Test
	public void fun4() {
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.find();
	}
}
