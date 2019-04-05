package pandy.test.mybatis.junit;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
 
import pandy.test.mybatis.dao.UserDao;
import pandy.test.mybatis.dao.UserDaoImpl;
import pandy.test.mybatis.pojo.User;

public class MybatisDaoTest {
	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testDao() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
