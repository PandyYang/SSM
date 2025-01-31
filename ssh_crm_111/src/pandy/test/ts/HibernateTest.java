package pandy.test.ts;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pandy.test.dao.UserDao;
import pandy.test.domain.User;
import pandy.test.service.UserService;

//测试hibernate框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Test
	public void fun1() {
		//加载配置
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//-------------------------
		User u = new User();
		u.setUser_code("tinyfry");
		u.setUser_name("攀迪");
		u.setUser_password("123");
		session.save(u);
		//-------------------------
		tx.commit();
		session.close();
		sf.close();
}
	@Test
	public void fun2() {
		//加载配置
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//-------------------------
		User u = new User();
		u.setUser_code("lily");
		u.setUser_name("小李");
		u.setUser_password("123");
		session.save(u);
		//-------------------------
		tx.commit();
		session.close();
		sf.close();
	}
	//测试dao hibernate模板
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3() {
		User u = ud.getByUserCode("tom");
		System.out.println(u);
		
	}
	//测试事务
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun4() {
		User u = new User();
		u.setUser_code("mm");
		u.setUser_name("呵呵付筝弦");
		u.setUser_password("123");
		us.saveUser(u);
		
	}
}