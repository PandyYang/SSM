package pandy.test.b_state;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;
//三种状态的特点
//save方法：其实不能理解成保存，理解成将瞬时状态，保存为持久化状态
//主键自增，执行save方法时，为了将对象转化为持久化状态，所以必须生成id值，所以需要执行insert语句
public class Demo {
	@Test
	public void fun1() {
		
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.执行操作
		//Customer c = new Customer();//没有id，没有与session关联，=>瞬时状态
		//c.setCust_name("华硕");//瞬时状态
		//session.save(c);//持久化状态，有id，有关联
		Customer c = session.get(Customer.class,1L);//持久化状态对象
		c.setCust_name("Microft");
		//4.提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态，有id，没有关联
	}
}
