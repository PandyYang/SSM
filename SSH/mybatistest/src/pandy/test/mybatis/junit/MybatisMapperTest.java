package pandy.test.mybatis.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pandy.test.mybatis.mapper.OrderMapper;
import pandy.test.mybatis.pojo.Orders;
import pandy.test.mybatis.pojo.QueryVo;
import pandy.test.mybatis.pojo.User;
import pandy.test.mybatis.utils.GetMapperUtils;
import pandy.test.mybatis.utils.GetUserMapperUtils;

public class MybatisMapperTest {
	
	private GetUserMapperUtils gs = new GetUserMapperUtils();
	private GetMapperUtils gm  = new GetMapperUtils();
	@Test
	public void testMapper() throws Exception{
		User user = gs.getUserMapper().findUserById(10);
		System.out.println(user);
	}
	
	//动态代理对象调用selectone与selectlist时根据mapper接口的方法的返回值进行确定
	//如果返回list调用selectlist方法  如果返回单个对象  则调用的是selectOne方法  
	@Test
	public void testMapper2() throws Exception{
		
		List<User> lists = gs.getUserMapper().findUserByUsername("王五");
		for(User list:lists) {
			System.out.println(list);
		}
	}
	
	@Test
	public void testMapperQueryVo() throws Exception {
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		List<User> us =  (List<User>) gs.getUserMapper().findUserByQueryVo(vo);
		for(User u:us) {
			System.out.println(u);
		}
		
	}
	
	//测试用户的数量
	@Test
	public void countUser() throws Exception {
	
		Integer i = gs.getUserMapper().countUser();
		System.out.println(i);
		
	}
	
	//测试订单表order的所有数据
	//因为UserId中没有值 所以映射出来的文件中值全部是null
	//所以需要将OrderMapper中的ResultType改成ResultMap()
	//注意只有在pojo中的属性名和数据库中的属性名一致的时候才能使用resulttype
	//在使用resultmap的时候记得在上面配置resultmap标签 标签中配置各种信息
	@Test
	public void testselectOrderList() throws Exception {
		List<Orders> ls = gm.getOrderMapper().selectOrderList();
		for(Orders l:ls) {
			System.out.println(l);
		}
	}
	//根据用户名和性别查询用户
	@Test
	public void testfindUserBySexAndUsername() throws Exception {
		User user = new User();
		//user.setSex("1");
		user.setUsername("张小明");
		//
		List<User> users =  gs.getUserMapper().selectUserBySexAndUsername(user);
		for(User user1 : users) {
			System.out.println(user1);
		}
	}
	//根据多个id查询用户
	@Test
	public void testfindUserByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(16);
		ids.add(22);
		ids.add(24);
		QueryVo vo = new QueryVo();
		vo.setIdsList(ids);
		List<User> users = gs.getUserMapper().selectUserByIds(vo);
		for(User u:users) {
			System.out.println(u);
		}
	}
	@Test
	public void testOrderList() {
		OrderMapper orderMapper = gm.getOrderMapper();
		List<Orders> lists = orderMapper.selectOrders();
		for(Orders l:lists) {
			System.out.println(l);
		}
	}
	
	@Test
	public void testUserList() {
		List<User> lists = gm.getOrderMapper().selectUserList();
		for(User list:lists) {
			System.out.println(list);
		}
	}
}
