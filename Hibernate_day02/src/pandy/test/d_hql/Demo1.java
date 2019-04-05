
package pandy.test.d_hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;
//测试主键生成
public class Demo1{
	@Test
	public void fun1() {
		
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//------------------
		//书写hql语句，根据hql语句创建查询对象
		String hql = "from Customer where cust_id =1";
		//根据查询语句创建查询对象
		Query query = session.createQuery(hql);
		//根据查询对象获得查询结果
		//当确定返回的实例只有一个或者null时 用uniqueResult()方法   
		Customer c = (Customer) query.uniqueResult();
		System.out.println(c);
		//List<Customer> list = query.list();//返回list结果
		//query.uniqueResult();//接受唯一的查询结果
		//------------------
		//System.out.println(list);
		tx.commit();
		session.close();
		
	}
}
