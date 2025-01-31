package pandy.work.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pandy.work.bos.dao.IUserDao;
import pandy.work.bos.domain.User;
import pandy.work.bos.service.IUserService;
import pandy.work.bos.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//其实真正的实际操作只在dao层  现在只需要从dao层中注入进来即可
	@Autowired
	private IUserDao userDao;
	/*
	 * 用户的登录的方法
	 * */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//使用md5加密
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassWord(user.getUsername(),password);
	}
	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		password=MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
	
}
