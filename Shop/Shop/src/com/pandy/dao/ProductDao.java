package com.pandy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pandy.domain.Category;
import com.pandy.domain.Product;
import com.pandy.utils.DataSourceUtils;

/**
* @author Pandy
* @version 2018年11月15日 下午10:07:14
*query更多的时候用来执行 无需参数的选择查询
*update 被用来指定插入 删除 更新的操作
*/
public class ProductDao {
	//查找热门商品
	public List<Product> findHotProductList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = ? limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class),1,0,9);
		
	}
	//查找最新商品
	public List<Product> findNewProductList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class),0,9);
	}
	//查询商品的类别
	public List<Category> findAllCategory() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
		
	}
	//获得总条数
	public int getCount(String cid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid=?";
		//scalarHandler将单个值封装
		Long query = (Long) runner.query(sql, new ScalarHandler(),cid);
		return query.intValue();
	}
	//分页查询
	public List<Product> findProductByPage(String cid, int index, int currentCount) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class),cid,index,currentCount);
		return list;
	}
	//根据pid查询商品
	public Product findProductByPid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid = ?";
		return runner.query(sql, new BeanHandler<Product>(Product.class),pid);
		
	}

}
