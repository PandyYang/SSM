package pandy.test.dao;

import java.util.List;

import pandy.test.domain.Customer;

public interface CustomerDao {
	//保存客户
	void save(Customer c);
	//查询所有客户
	List<Customer> getAll();
	//根据id获得客户
	Customer getById(Long cust_id);

	
}
