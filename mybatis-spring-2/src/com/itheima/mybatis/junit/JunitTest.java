package com.itheima.mybatis.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.pojo.UserExample;

public class JunitTest {

	
	@Test
	public void testMapper() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = ac.getBean(UserMapper.class);//spring整合之后 直接传进bean文件
		UserExample example = new UserExample();
		String username = "明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%" + username + "%");//多个条件进行查询
		
		example.setOrderByClause("id desc");
		
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
		
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user);
		
		List<User> users = userMapper.selectByExample(example);
		for (User user2 : users) {
			System.out.println(user2.getId());
		}
	}
}
