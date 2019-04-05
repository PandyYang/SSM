package pandy.test.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pandy.test.mybatis.mapper.OrderMapper;

public class GetMapperUtils {
	public OrderMapper getOrderMapper() {
		String resource = "sqlMapConfig.xml";
		InputStream in = null;
		try {
			//从classpath根目录下获取
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession 能够执行映射文件中的sql的sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession帮我的接口生成一个实现类
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper;
	}
}
