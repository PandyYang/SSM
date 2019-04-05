package pandy.test.a_generator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;
//测试主键生成
public class Demo {
	@Test
	public void fun1() {
		
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.执行操作
		Customer c = new Customer();
		c.setCust_name("怎么办");
		session.save(c);
		//4.提交事务，关闭资源
		tx.commit();
		session.close();
	}
}
