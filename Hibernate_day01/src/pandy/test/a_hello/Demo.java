package pandy.test.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pandy.test.domain.Customer;

public class Demo {
	@Test
	public void fun1() {
		//加载在classpath下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
		//通过会话连接工厂
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//创建session
		Session session = sessionFactory.openSession();//Session session = hibernate.openSession()
		//开启事务
		Transaction tx = session.beginTransaction();
		//..............
		Customer c= new Customer();
		c.setCust_name("为什么");
		session.save(c);
		//--------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
