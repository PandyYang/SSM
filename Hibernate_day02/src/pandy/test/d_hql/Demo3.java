package pandy.test.d_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

public class Demo3 {
	@Test
	public void fun3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Customer where cust_id = ?";
		Query query = session.createQuery(sql);
		//query.setLong(0,1l);
		query.setParameter(0,1l);
		Customer c = (Customer)query.uniqueResult();
 		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	//条件查询
	//命名占位符
	public void fun4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Customer where cust_id = :cust_id";
		Query query = session.createQuery(sql);
		//query.setLong(0,1l);
		query.setParameter("cust_id",1l);
		Customer c = (Customer)query.uniqueResult();
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	@Test
	//条件查询
	//命名占位符
	public void fun5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Customer";
		Query query = session.createQuery(sql);
		//query.setLong(0,1l);
		
		//从第几条开始抓取 最大抓取几条数据
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		tx.commit();
		session.close();
	}
}
