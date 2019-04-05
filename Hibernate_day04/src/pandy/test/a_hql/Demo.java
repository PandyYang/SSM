package pandy.test.a_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

//学习hql语法
public class Demo {
	
	//基本语法
	@Test
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "from pandy.test.domain.Customer";//完整写法
		String hql2 = "from Customer";//简单写法
		String hql3 = "from java.lang.Object";//查询所有的表
		
		Query query = session.createQuery(hql3);
		List list = query.list();
		
		System.out.println(list);
		//---------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//排序语法
	public void fun2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "from pandy.test.domain.Customer order by cust_id asc";//完整写法
		String hql2 = "from pandy.test.domain.Customer order by cust_id desc";//完整写法
		
		//Query query = session.createQuery(hql1);
		Query query = session.createQuery(hql2);
		
		List list = query.list();
		
		System.out.println(list);
		//---------------------
		tx.commit();
		session.close();
	}
	
	
	@Test
	//条件查询
	public void fun3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "from pandy.test.domain.Customer where cust_id =?";//完整写法
		String hql2 = "from pandy.test.domain.Customer where cust_id =:id";//完整写法
		
		Query query = session.createQuery(hql1);
		//Query query = session.createQuery(hql2);
		
		//limit?,?
		//当前页数-1 * 每页的条数
		query.setFirstResult(0);
		query.setMaxResults(1);
		
		query.setParameter(0,2l);
		//query.setParameter("id",2l);
		
		List list = query.list();
		
		System.out.println(list);
		//---------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//分页查询
	public void fun4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "from pandy.test.domain.Customer";//完整写法
		
		
		Query query = session.createQuery(hql1);
	
		//limit?,?
		//当前页数-1 * 每页的条数
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List list = query.list();
		
		System.out.println(list);
		//---------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//统计查询
	//count sum avg max min 
	public void fun5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "select count(*) from pandy.test.domain.Customer";//完整写法
		String hql2 = "select sum(cust_id) from pandy.test.domain.Customer";
		String hql3 = "select avg(cust_id) from pandy.test.domain.Customer";
		String hql4 = "select max(cust_id) from pandy.test.domain.Customer";
		String hql5 = "select min(cust_id) from pandy.test.domain.Customer";
		
		Query query = session.createQuery(hql1);
	
		Number number = (Number) query.uniqueResult();
		System.out.println(number);
		//---------------------
		tx.commit();
		session.close();
	}
	
	
	@Test
	//投影查询
	//count sum avg max min 
	public void fun6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------
		String hql1 = "select cust_name from pandy.test.domain.Customer";//完整写法
		String hql2 = "select cust_name,cust_id from pandy.test.domain.Customer";
		String hql3 = "select new Customer(cust_id,cust_name) from pandy.test.domain.Customer";
		Query query = session.createQuery(hql3);
	
		List list = query.list();
		System.out.println(list);
		//---------------------
		tx.commit();
		session.close();
	}
}
