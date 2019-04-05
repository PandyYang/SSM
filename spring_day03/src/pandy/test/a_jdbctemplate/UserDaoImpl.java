package pandy.test.a_jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import pandy.test.bean.User;
//使用jdbc模板实现增删改查
//继承以下类 可以根据连接池创建jdbc模板 不需要手动准备jdbc模板对象 从父类的方法中直接获取
//可以将一下的所有jt修改成super.getJdbcTemplate()
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	//private JdbcTemplate jt;
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user values(null,?)";
		super.getJdbcTemplate().update(sql, u.getName());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user where id = ?";
		getJdbcTemplate().update(sql,id);
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		String sql = "update t_user set name=? where id =?";
		getJdbcTemplate().update(sql,u.getName(),u.getId());
	}

	public User getById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where id =?";
		//将数据库中的每一行数据封装成用户自定义的类
		return getJdbcTemplate().queryForObject(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				// TODO Auto-generated method stub
				return u;
			}},id);
		
	}

	public int getTotalCount() {
		String sql = "select count(*) from t_user";
		Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);//返回的是integer类的对象
		return count;
		// TODO Auto-generated method stub
	}

	public List<User> getAll() {
		String sql = "select * from t_user";
		List<User> list = getJdbcTemplate().query(sql,new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				// TODO Auto-generated method stub
				return u;
			}});
		// TODO Auto-generated method stub
		return list;
	}
}
