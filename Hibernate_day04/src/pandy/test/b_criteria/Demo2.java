package pandy.test.b_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;
//学习离线Criteria 可以在service层
public class Demo2 {
	@Test
	//基本语法
	public void fun1() {
		
		//service/web层
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.idEq(4l));//拼装条件（全部与普通Criteria一致）
		
		//
		Session session = HibernateUtils.openSession();//创建事务
		Transaction tx = session.beginTransaction();//开启事务
		
		Criteria c = dc.getExecutableCriteria(session);
		List list = c.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
}
