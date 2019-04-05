package pandy.test.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pandy.test.dao.UserDao;
import pandy.test.domain.User;
import pandy.test.service.UserService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	//生成dao方法由spring进行注入
	private UserDao ud;
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User getUserByCodePassword(User u) {
		// TODO Auto-generated method stub
		//1.根据登陆名称查询登陆用户
		User existU = ud.getByUserCode(u.getUser_code());
		//2.判断用户是否存在 如果不存在抛出异常
		if (existU==null) {
			throw new RuntimeException("用户名不存在");
		}
		//3.判断密码是否正确
		if (!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		//4.返回查询到的用户对象
		
		return existU;

	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		ud.save(u);
	}
	
}
