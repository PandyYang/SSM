package pandy.test.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pandy.test.mybatis.mapper.UserMapper;

public class GetUserMapperUtils {
	//抽取出一个获取userMapper.class的实现类的工具类
	public UserMapper getUserMapper() {
		String resource = "sqlMapConfig.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession帮我的接口生成一个实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper;
	}
	
}
