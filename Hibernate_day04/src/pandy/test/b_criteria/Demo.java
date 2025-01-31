package pandy.test.b_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;
//面向对象的查询方式 Criteria语法
public class Demo {
	@Test
	//基本语法
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	@Test
	//添加语法
	public void fun2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		c.add(Restrictions.eq("cust_id", 2l));
		List<Customer> list = c.list();
		//c.add(Restrictions.idEq(2l));		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	@Test
	//分页操作
	public void fun3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		
		c.setFirstResult(0);
		c.setMaxResults(2);
		
		
		List<Customer> list = c.list();
		//c.add(Restrictions.idEq(2l));		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	@Test
	//排序语法
	public void fun4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		
		c.addOrder(Order.asc("cust_id"));
		//c.addOrder(Order.desc("cust_id"));
		
		List<Customer> list = c.list();
		//c.add(Restrictions.idEq(2l));		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	

	@Test
	//统计
	public void fun5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		//设置查询目标
		c.setProjection(Projections.rowCount());
		
		List list = c.list();
		//c.add(Restrictions.idEq(2l));		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
}
