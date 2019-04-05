package pandy.test.mybatis.dao;

import pandy.test.mybatis.pojo.User;

public interface UserDao {
	//通过用户id查询一个用户
	public User selectUserById(Integer id);
}
