package com.gyf.bos.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.gyf.bos.dao.IUserDao;
import com.gyf.bos.dao.base.BaseDaoImpl;
import com.gyf.bos.domain.User;

@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User>  implements IUserDao{

	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> users = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		
		if(users != null && users.size() > 0) return users.get(0);
		return null;
	}

	@Override
	public User findByUsername(String username) {
		String hql = "FROM User u WHERE u.username = ?";
		List<User> users = (List<User>) this.getHibernateTemplate().find(hql, username);
		
		if(users != null && users.size() > 0) return users.get(0);
		
		return null;
	}

	

	

}
