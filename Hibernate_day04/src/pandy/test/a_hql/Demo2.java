package pandy.test.a_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.utils.HibernateUtils;

//多表查询语法
//下面的左表和右表
public class Demo2 {
	/*
	 * 内连接
	 * 		隐式内连接
	 * 		select * from A,B where b.aid = a.aid;
			显式内连接
	   		select * from A inner join B on b.aid = a.aid;
	   	外连接
	   		左外
	   		select * from A left [outer] join B on b.aid= a.aid;
	   		右外
	   		select * from B right [outer] join B on b.aid = a.aid;
	  */
	@Test
	public void fun1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		String hql="from Customer c inner join c.linkMens";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		session.close();
		
	}
}	

