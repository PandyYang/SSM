package pandy.test.d_lazy_fetch;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.domain.LinkMan;
import pandy.test.utils.HibernateUtils;
//集合级别的关联 延迟加载&抓取策略
public class Demo {
	@Test
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------
		Customer c = session.get(Customer.class, 2l);
		Set<LinkMan> linkMens = c.getLinkMens();//关联
		System.out.println(linkMens);
		//----------------------------------------
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	public void fun2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------
		String hql= "from Customer";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		for(Customer c:list) {
			System.out.println(c);
			System.out.println(c.getLinkMens().size());
			System.out.println(c.getLinkMens());
			
		}
		//----------------------------------------
		
		tx.commit();
		session.close();
	}
}
