package pandy.test.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pandy.test.dao.CustomerDao;
import pandy.test.domain.Customer;
import pandy.test.service.CustomerService;
import pandy.test.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		//1.调用dao查询总记录数
		Integer totalcount = cd.getTotalCount(dc);
		//2.创建pageBean对象
		PageBean pb = new PageBean(currentPage,totalcount,pageSize);
		//3.调用dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4.将列表数据放进pagebean中并返回
		pb.setList(list);
		return pb;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
