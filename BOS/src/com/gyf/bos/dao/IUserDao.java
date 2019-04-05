package com.gyf.bos.dao;

import com.gyf.bos.dao.base.IBaseDao;
import com.gyf.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public User findByUsernameAndPassword(String username,String password);
	public User findByUsername(String username);
	
}
