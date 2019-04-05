package com.pandy.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pandy.domain.User;
import com.pandy.utils.DataSourceUtils;

/**
* @author Pandy
* @version 2018年11月14日 下午8:44:56
*
*/
public class UserDao {
	//注册
	public int regist(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		//下面的变量名 与数据库中的变量名一致 才能够正确插入
		//返回值必须大于零才能成功 否则的话都是失败
		int update = runner.update(sql, user.getUid(),user.getUsername(),user.getPassword()
				,user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday()
				,user.getSex(),user.getState(),user.getCode());
		return update;
	}
	//激活
	public void active(String activeCode) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state=? where code=?";
		runner.update(sql,1,activeCode);
	}
	//校验用户名是否存在
	public Long checkUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where username = ?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),username);
		return query;
	}
}
