package pandy.test.mybatis.junit;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pandy.test.mybatis.mapper.UserMapper;
import pandy.test.mybatis.pojo.User;

public class junitTest {
	
	@Test
	public void testname() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
}
