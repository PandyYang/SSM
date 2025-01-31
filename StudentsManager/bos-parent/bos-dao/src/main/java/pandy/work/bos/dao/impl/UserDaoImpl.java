package pandy.work.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import pandy.work.bos.dao.IUserDao;
import pandy.work.bos.dao.base.impl.BaseDaoImpl;
import pandy.work.bos.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	/**
	 * 根据用户名和密码查询用户
	 */

	@Override
	public User findUserByUsernameAndPassWord(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
