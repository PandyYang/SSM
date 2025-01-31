package pandy.test.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Customer;
import pandy.test.domain.LinkMan;
import pandy.test.utils.HibernateUtils;

//一对多  多对一关系的操作
public class Demo {
	@Test
	//保存客户以及客户下的联系人
	public void fun1() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		
		//-----------------------------------------------------
		
		//3.操作
		Customer c =new Customer();
		c.setCust_name("两仪式");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黑桐");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("干也");
		
		//表达一对多关系 客户下有多个联系人
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);
		
		//表达多对多关系，联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(c);
		session.save(lm1);
		session.save(lm2);
		//----------------------------------------------------
		
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
	
	@Test
	//为客户增加联系人
	public void fun2() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------------
		//3.操作
		//(1).获得要操作的客户对象
		Customer c = session.get(Customer.class,1l);
		//(2).创建联系人
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("测试");
		//(3).将联系人添加到客户，将客户设置到联系人中
		c.getLinkMens().add(lm1);
		lm1.setCustomer(c);
		//(4).执行保存
		session.save(lm1);	
		//----------------------------------------------------
		
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
	
	@Test
	//为客户删除联系人
	public void fun3() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------------
		//3.操作
		//(1).获得要操作的客户对象
		Customer c = session.get(Customer.class,102l);
		//(2).获得要移除的联系人
		LinkMan lm = session.get(LinkMan.class,102l);
		//(3).将联系人从客户集合之中移除
		c.getLinkMens().remove(lm);
		lm.setCustomer(null);
		//----------------------------------------------------
		
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
}
