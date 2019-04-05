package com.pandy.domain;

import java.util.List;

/**
* @author Pandy
* @version 2018年11月18日 下午3:27:52
*
*/
public class PageBean<T> {
	//当前页
	private int currentPage;
	//当前条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage;
	//数据
	private List<T> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
