package pandy.test.mybatis.mapper;

import java.util.List;

import pandy.test.mybatis.pojo.Orders;
import pandy.test.mybatis.pojo.User;

public interface OrderMapper {
	//查询订单表order的所有数据
	public List<Orders> selectOrderList();
	//一对一关联 查询 以订单为中心关联用户
	public List<Orders> selectOrders();
	//一对多关联
	public List<User> selectUserList();
}
