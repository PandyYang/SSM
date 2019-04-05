package com.itheima.domain;
/**
* @author Pandy
* @version 2018年11月21日 下午9:13:06
*订单项表中 的属性有 它的唯一的id值 
*以及商品的数量 以及小计 对应的商品的id值
* 和对应的order的外键
*/
public class OrderItem {
	
	private String itemid;
	private int count;
	private double subtotal;
	//private String pid;//作废 对应下面的product
	//private String oid;//作废 对应下面的order
	private Product product;
	private Order order;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
/*	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}*/
	
}
