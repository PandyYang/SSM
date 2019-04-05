package pandy.test.b_many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pandy.test.domain.Role;
import pandy.test.domain.User;
import pandy.test.utils.HibernateUtils;

public class Demo {
	@Test
	//保存员工以及角色
	public void fun1() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.操作
		//1>创建两个User
		User u1 = new User();
		u1.setUser_name("用户1");
		User u2 = new User();
		u2.setUser_name("用户2");
		//2>创建两个Role
		Role r1 = new Role();
		r1.setRole_name("员工1");
		Role r2 = new Role();
		r2.setRole_name("员工2");
		//3>用户表达关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		//4>角色表达关系
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		//5>调用save方法一次
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
	
	
	@Test
	//为用户1新增加一个员工职位
	public void fun2() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.操作
		//1>获得用户1
		User user = session.get(User.class,1L);
		//2>创建公关角色
		Role r = new Role();
		r.setRole_name("公关");
		//3>将角色添加到用户中
		user.getRoles().add(r);
		//4>将角色转化为持久化
		//session.save(r);//使用级联操作可以简化此行
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
	
	
	@Test
	//为用户1接触一个角色
	//get获取到的直接就是持久化的对象  所以不需要进行其他的操作
	public void fun3() {
		//1.获得session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.操作
		//1>获得用户
		User user = session.get(User.class,1L);
		//2>获得要操作的角色对象
		Role r1 = session.get(Role.class,4L);
		//3>将角色从用户集合之中进行移除
		user.getRoles().remove(r1);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
}
