package pandy.test.mybatis.mapper;

import java.util.List;

import pandy.test.mybatis.pojo.QueryVo;
import pandy.test.mybatis.pojo.User;

public interface UserMapper {

	
	//遵循四个原则
	//接口 方法名==User.xml中的id名
	//返回值类型 要与Mapper.xml文件中的返回值类型要一致
	//方法的入参类型  要与mapper.xml文件中的入参类型要一致
	//绑定接口 为了防止与user.xml文件的类似冲突 就是在namespace中直接精确到此类
	public User findUserById(Integer id);
	public List<User> findUserByUsername(String name);
	public List<User> findUserByQueryVo(QueryVo vo);
	//查询用户 条数
	public Integer countUser();
	//根据用户的性别与姓名查询用户
	public List<User> selectUserBySexAndUsername(User user);
	//根据多个id查询用户
//	public List<User> selectUserByIds(Integer[] ids);
//	public List<User> selectUserByIds(List<Integer> ids);
	public List<User> selectUserByIds(QueryVo vo);
}
