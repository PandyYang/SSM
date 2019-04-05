package pandy.test.service.impl;

import pandy.test.dao.CustomerDao;
import pandy.test.dao.LinkManDao;
import pandy.test.dao.impl.CustomerDaoImpl;
import pandy.test.dao.impl.LinkManDaoImpl;
import pandy.test.domain.Customer;
import pandy.test.domain.LinkMan;
import pandy.test.service.LinkManService;
import pandy.test.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao lmd = new LinkManDaoImpl();
	private CustomerDao cd = new CustomerDaoImpl();
	public void save(LinkMan lm) {
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			// TODO Auto-generated method stub
			//1.根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2.将客户放入到LinkMan之中
			lm.setCustomer(c);
			//3/保存LinkMan
			lmd.save(lm);
		}catch(Exception e){
			e.printStackTrace();
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			System.out.println("出错了");
		}
		
		
		
		HibernateUtils.getCurrentSession().getTransaction().commit();
	}

}
