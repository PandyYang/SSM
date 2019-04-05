package pandy.test.c_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pandy.test.bean.User;

public class Demo {
	
	@Test
	public void fun1() {
		
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/c_injection/applicationContext.xml");
		//2.向容器要user对象
		User u = (User) ac.getBean("user");
		//3.打印user对象
		System.out.println(u);
	}
	
	@Test
	public void fun2() {
		
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/c_injection/applicationContext.xml");
		//2.向容器要user对象
		User u = (User) ac.getBean("user2");
		//3.打印user对象
		System.out.println(u);
	}
	@Test
	public void fun3() {
		
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("pandy/test/c_injection/applicationContext.xml");
		//2.向容器要user对象
		User u = (User) ac.getBean("user3");
		//3.打印user对象
		System.out.println(u);
	}
}
