package com.pandy.service;

import java.sql.SQLException;
import java.util.List;

import com.pandy.dao.ProductDao;
import com.pandy.domain.Category;
import com.pandy.domain.PageBean;
import com.pandy.domain.Product;

/**
* @author Pandy
* @version 2018年11月15日 下午10:02:00
*
*/
public class ProductService {
	ProductDao dao = new ProductDao();
	List<Product> hotProductList = null;
	//获得热门的商品
	public List<Product> findHotProductList() {
		// TODO Auto-generated method stub1
		
		 try {
			hotProductList = dao.findHotProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return hotProductList;
		
	}
	//获得最新商品
	List<Product> newProductList = null;
	public List<Product> findNewProductList() {
		// TODO Auto-generated method stub
		try {
			newProductList = dao.findNewProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newProductList;
	}
	//查询商品的类别
	//将其初始化为null的目的在于如果出现异常就返回null
	List<Category> categoryList = null;
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		try {
			categoryList = dao.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
	//分页
	public PageBean findProductListByCid(String cid,int currentPage,int currentCount) {
		
		
		// TODO Auto-generated method stub
		//此处的目的就是封装一个pageBean返回给web
		PageBean<Product> pageBean = new PageBean<Product>();
		
		//1.封装当前页
		pageBean.setCurrentPage(currentPage);
		//2.封装每一页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3.封装的总条数
		int totalCount = 0;
		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		//4.封装总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5.当前页显示的数据 
		//需要传入三个参数 cid 起始索引 需要显示的条数
		// select * from product where cid=? limit ?,?
		//使用数学公式 当前页与起始索引index 的关系
		int index = (currentPage-1)*currentCount;
		List<Product> list = null;
		try {
			//list会将类别 查询的区通过pageBean返回给web
			list = dao.findProductByPage(cid,index,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setList(list);
		return pageBean;
	}
	//根据pid查询商品
	public Product findProductByPid(String pid) {
		// TODO Auto-generated method stub
		Product product= null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
}
