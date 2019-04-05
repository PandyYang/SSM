package pandy.test.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pandy.test.mybatis.pojo.User;

public class MyBatisFirstTest {
	
	//成员变量
	
	
	
	
	//根据id值查询用户
	@Test
	public void testfindUserById() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行语句
		User user = sqlSession.selectOne("test.findUserById",10);
		System.out.println(user);
	}
	
	//根据用户名模糊查询用户列表
	@Test
	public void testfindUserByUsername() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行语句
		List<User> user = sqlSession.selectList("test.findUserByUsername","五");
		for(User u : user) {
			System.out.println(u);
		}
	}
	
	//保存用户
	@Test
	public void testsaveUser() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行语句
		User user = new User();
		
		user.setUsername("滴滴答");
		user.setBirthday(new Date());
		user.setAddress("咸阳");
		user.setSex("男");
		
		int i = sqlSession.insert("test.saveUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	
	//修改用户
	@Test
	public void testupdateUserById() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行语句
		User user = new User();
		user.setId(29);
		user.setUsername("哈哈哈");
		user.setBirthday(new Date());
		user.setAddress("墨尔本");
		user.setSex("男");
		
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		
	}
	
	
	
	//删除用户
		@Test
		public void testdeleteUserById() throws Exception {
			//加载核心配置文件
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			//创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			//创建SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//执行语句
			User user = new User();
			
			int i = sqlSession.delete("test.deleteUserById", 29);
			sqlSession.commit();
			
	}
		
		
}
