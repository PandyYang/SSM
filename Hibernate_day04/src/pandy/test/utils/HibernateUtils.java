package pandy.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	//只在类加载时执行一次 类加载在缓存区 一个类只加载一次
	static {
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		
	}
	
	//获得session=>获得全新session
	public static Session openSession() {
		Session session = sf.openSession();
		return session;
	}
	//获得session=>获得与线程绑定的session
	public static Session getCurrentSession() {
		
		Session session = sf.openSession();
		return session;
	}
	public static void main(String[] args) {
		System.out.println(HibernateUtils.openSession());
	}
}
