package pandy.test.a_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pandy.test.bean.User;

public class Demo {
	@Test
	public void fun1() {
		
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		System.out.println(u1==u2);
		System.out.println(u1);
		ac.close();
	}
}
