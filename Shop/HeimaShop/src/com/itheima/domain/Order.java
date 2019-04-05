package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author Pandy
* @version 2018年11月21日 下午9:18:33
*
*/
public class Order {
	private String oid;//该订单的订单号
	private Date ordertime;//下单的时间
	private double total;//该订单的总金额
	private int state;//订单的支付状态 1代表已经付款 0代表还未付款
	//注意当前的登录者  与收货人可能不是一个人
	private String address;//收货地址
	private String name;//收货人
	private String telephone;//收货人电话
	
	private User user;//该订单属于哪个用户
	//因为最后的总订单要么支付 要么取消所以定义为List  而购物车中的订单项以Map的形式存储商品
	List<OrderItem> orderItems = new ArrayList<OrderItem>();//该订单中可能包含多个订单项
	//就算Order中维护着对应每个OrderItem 也就是说Order不去认领OrderItem
	//每个OrderItem身上都标识着自己属于哪个Order  但是问题是 如果在往数据库中写数据
	//在每个层中传递数据的时候 如果维护这这个集合 那么传递一个Order 也就相当于传递了所有的数据
	
	
	public String getOid() {
		return oid;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
