package com.pandy.service;

import java.sql.SQLException;

import com.pandy.dao.UserDao;
import com.pandy.domain.User;

/**
* @author Pandy
* @version 2018年11月14日 下午8:42:42
*
*/
public class UserService {
	public boolean regist(User user){
		
		UserDao dao = new UserDao();
		int row=0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row>0?true:false;
	}
	//激活用户
	public void active(String activeCode) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		dao.active(activeCode);
	}
	//校验用户名是否存在
	public boolean checkUsername(String username){
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		Long isExist = 0L;
		try {
			 isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}
}
