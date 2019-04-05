package pandy.test.a_jdbctemplate;

import java.util.List;

import pandy.test.bean.User;

public interface UserDao {
	//增
	void save(User u);
	//删
	void delete(Integer id);
	//改
	void update(User u);
	//查
	User getById(Integer id);//根据id进行查询
	int getTotalCount();//获取相关类型的总数
	List<User> getAll();//获取总数
	
}
