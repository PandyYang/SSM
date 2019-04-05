package pandy.work.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pandy.work.crm.mapper.CustomerDao;
import pandy.work.crm.pojo.Customer;
import pandy.work.crm.pojo.QueryVo;
import pandy.work.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	//通过四个添加 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//设置每一页显示5条
		vo.setSize(5);
		page.setSize(5);
		//对当前页进行判断
		if(null != vo) {
			if(null != vo.getPage()) {
			page.setPage(vo.getPage());
			vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			//下面的值要是不选的话 在前端中默认设置的是字符串
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//设置总条数
			page.setTotal(customerDao.selectCustomerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}
	@Override
	public Customer selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerById(id);
	}
	//根据id删除用户
	@Override
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomerById(id);
	}
	//根据客户对象进行更新
	//之所以使用客户对象 是因为要更新的值比较多  直接对对象进行操作 方便
	@Override
	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomerById(customer);
	}
	
}
