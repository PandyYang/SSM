package pandy.test.dao.impl;

import org.hibernate.Session;

import pandy.test.dao.LinkManDao;
import pandy.test.domain.LinkMan;
import pandy.test.utils.HibernateUtils;
//保存联系人
public class LinkManDaoImpl extends LinkManDao {
	public void save(LinkMan lm) {
		
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}
}
