package pandy.test.a_jdbctemplate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import pandy.test.bean.User;

//演示JDBC模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
		@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void fun1() throws Exception{
		
		//0 准备连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate_32");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		//1 创建JDBC模板对象
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		//2 书写sql,并执行
		String sql = "insert into t_user values(null,'rose') ";
		jt.update(sql);
		
	}
	
	@Test
	public void fun2() throws Exception{
		User u = new User();
		u.setName("tom");
		ud.save(u);
	}
	@Test
	public void fun3() throws Exception{
		User u = new User();
		u.setId(2);
		u.setName("jack");
		ud.save(u);
	}
	@Test
	public void fun4() throws Exception{
		User u = new User();
		u.setId(3);
		u.setName("fry");
		ud.update(u);
	}
	//在userdao的接口中需要u的部分才需要创建user的实例对象 否则的话直接调用userdao中的方法即可
	@Test
	public void fun5() throws Exception{
		ud.delete(3);
	}
	//查询表中的用户数量
	@Test
	public void fun6() throws Exception{
		Integer totalcount = ud.getTotalCount();
		System.out.println(totalcount);
	}
	@Test
	public void fun7() throws Exception{
		
		System.out.println(ud.getById(1));
	}
	@Test
	public void fun8() throws Exception{
		
		System.out.println(ud.getAll());
	}
}