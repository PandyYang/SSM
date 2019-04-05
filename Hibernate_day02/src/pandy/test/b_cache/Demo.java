package pandy.test.b_cache;

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
		Customer c1 = session.get(Customer.class,1l);
		Customer c2 = session.get(Customer.class,1l);
		Customer c3 = session.get(Customer.class,1l);
		Customer c4 = session.get(Customer.class,1l);
		
		System.out.println(c1==c2);
		//4.提交事务，关闭资源
		tx.commit();
		session.close();
	}
}
