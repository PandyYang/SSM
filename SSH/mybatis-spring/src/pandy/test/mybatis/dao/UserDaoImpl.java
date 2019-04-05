package pandy.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 * 原始dao开发
 * @author ASUS
 *声明一个工厂 Set方式
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	//声明工厂
	public void insertUser() {
	//	this.getSqlSession().insert(arg0)
	}
}
