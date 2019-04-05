package pandy.test.e_fetchsize;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

public class Demo {
	@Test
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for(Customer c:list) {
			
			System.out.println(c.getLinkMens());
		}
		
		tx.commit();
		session.close();
		
	}
}
