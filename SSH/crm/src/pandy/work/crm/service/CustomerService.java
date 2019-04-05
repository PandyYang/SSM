package pandy.work.crm.service;

import pandy.work.crm.pojo.Customer;
import pandy.work.crm.pojo.QueryVo;
import pandy.work.crm.utils.Page;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	public Customer selectCustomerById(Integer id);
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(Integer id);
}
