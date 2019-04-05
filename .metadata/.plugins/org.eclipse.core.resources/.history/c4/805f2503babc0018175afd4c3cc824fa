package pandy.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import pandy.test.dao.CustomerDao;
import pandy.test.domain.Customer;
import pandy.test.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	public void save(Customer c) {
		// TODO Auto-generated method stub
		//1.获得session
		//Session session = HibernateUtils.openSession();
		Session session = HibernateUtils.getCurrentSession();
		
		//2.打开事务
		/*Transaction tx = session.beginTransaction();*/
		//3.执行保存
		session.save(c);
		//4.提交事务
		//tx.commit();
		//5.关闭资源
		//session.close();
	}
	public List<Customer> getAll(){
		//1.创建session
		Session session = HibernateUtils.getCurrentSession();
		//2.创建criteria对象
		Criteria c = session.createCriteria(Customer.class);
		
		
		return c.list();
	}
	public Customer getById(Long cust_id){
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Customer.class,cust_id);
}

}
