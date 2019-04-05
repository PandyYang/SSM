package pandy.test.d_tx;

import org.hibernate.Session;
import org.junit.Test;

import pandy.test.utils.HibernateUtils;

public class Demo {
 
	@Test
	public void fun1() {
		Session session1 = HibernateUtils.getCurrentSession();
		Session session2 = HibernateUtils.getCurrentSession();
		System.out.println(session1==session2);
	}
	
	@Test
	public void fun2() {
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		System.out.println(session1==session2);
	}
}
