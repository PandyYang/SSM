package pandy.test.d_hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

public class Demo2 {
	@Test
	public void fun3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Customer where cust_id = ?";
		Query query = session.createQuery(sql);
		query.setLong(0,1l);
		Customer c = (Customer)query.uniqueResult();
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
}
