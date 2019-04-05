package pandy.test.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pandy.test.domain.Customer;

//学习session对象
//session对象功能：表达hibernate框架与数据库之间的连接（会话）
//session类似于JDBC年代的Connection对象，还可以完成对数据库中数据的增删改查操作
//session书hibernate操作数据库的核心对象

public class Demo3 {
	@Test
	public void fun1() {
		//1.创建，调用空参对象
		Configuration conf = new Configuration().configure();
		//2.读取指定的配置文件=>空参加载方法，加载src下的hibernate.cfg.xml文件
		/*conf.configure();*/
		//3.读取指定orm元数据（扩展）,如果主配置中已经引入了映射配置，不需要进行手动加载
		//conf.addResource(resourceName);
		//conf.addClass(persistentClass);
		
		//4.根据配置信息  创建SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//5.获得session
		//打开一个新的session对象
		Session session = sf.openSession();
		//获得一个与线程绑定的session对象
		
		//获得操作事务的tx对象
		Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的tx对象
		Transaction tx2 = session.beginTransaction();
		
		
		Customer c = new Customer();
		c.setCust_name("Pandy");
		session.save(c);
		
		tx2.commit();
		session.close();
		sf.close();
		
	}
	
}
