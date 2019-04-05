package pandy.test.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pandy.test.dao.UserDao;
import pandy.test.domain.User;
//hibernateDaoSupport 为dao注入sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
 
	public User getByUserCode(final String usercode) {
		
		//HQL的方式
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql="from User where user_code =? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
	}
		/*//Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list  = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if (list != null&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}*/

	public void save(User u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(u);
	}
	}
