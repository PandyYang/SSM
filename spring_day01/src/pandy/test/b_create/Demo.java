package pandy.test.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pandy.test.bean.User;

public class Demo {
	//创建方式1：空参构造
	@Test
	public void fun1() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/b_create/applicationContext.xml");
		//User u = (User) ac.getBean("user");
		//System.out.println(u);
	}
	
	@Test
	public void fun2() {
		//创建方式2：静态工厂方法
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/b_create/applicationContext.xml");
		User u = (User) ac.getBean("user2");
		System.out.println(u);
	}
	@Test
	public void fun3() {
		//创建方式2：（动态）实例工厂方法
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/b_create/applicationContext.xml");
		User u = (User) ac.getBean("user3");
		System.out.println(u);
	}
}
