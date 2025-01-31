package pandy.test.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pandy.test.dao.CustomerDao;
import pandy.test.dao.impl.CustomerDaoImpl;
import pandy.test.domain.Customer;
import pandy.test.service.CustomerService;
import pandy.test.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {
	

	private CustomerDao customerDao = new CustomerDaoImpl();

	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		//调用Dao保存客户
		try {
			customerDao.save(c);
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}
	public List<Customer> getAll(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = customerDao.getAll();
		tx.commit();
		return list;
		
	}
}
