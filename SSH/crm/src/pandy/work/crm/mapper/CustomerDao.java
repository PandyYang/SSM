package pandy.work.crm.mapper;

import java.util.List;

import pandy.work.crm.pojo.BaseDict;
import pandy.work.crm.pojo.Customer;
import pandy.work.crm.pojo.QueryVo;

public interface CustomerDao {
	//查询总条数
	public Integer selectCustomerCountByQueryVo(QueryVo vo);
	//分页的结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//根据id查询用户
	public Customer selectCustomerById(Integer id);
	//根据id更新用户
	public void updateCustomerById(Customer customer);
	//根据id删除用户
	public void deleteCustomerById(Integer id);
}
