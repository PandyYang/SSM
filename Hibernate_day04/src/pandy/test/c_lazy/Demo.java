package pandy.test.c_lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

public class Demo {
	@Test
	//get方法：立即加载 在执行方法的时候立即发送sql语句查询结果
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Customer c = session.get(Customer.class, 2l);
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	//load方法：在执行时不发送任何的sql语句，返回一个对象，在使用该对象的时候才执行查询
	//延迟加载 仅仅获得没有使用不会查询 在使用的时候才进行查询
	//使用debug进行验证  是否对类进行延迟加载 可以在class元素上配置lazy属性
	//lazy 的值要是等于true 那么加载的时候不进行查询 在使用的时候才进行查询
	//lazy 的值要是等于false 查询的时候就会进行加载
	public void fun2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Customer c = session.load(Customer.class, 2l);
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
}
