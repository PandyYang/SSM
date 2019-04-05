package pandy.test.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	public void increaseMoney(Integer id, double money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update("update t_account set money = money+? where id = ?",money,id);
	}

	public void decreaseMoney(Integer id, double money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update("update t_account set money = money-? where id = ?",money,id);

	}

}
