package com.gyf.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gyf.bos.utils.PageBean;

public interface IBaseDao<T> {

	/**
	 * IBaseDao:
	 * */
	public void save(T entity);
	
	/**
	 * IBaseDao:
	 * */
	public void update(T entity);
	
	/**
	 * IBaseDao:
	 * */
	public void delete(T entity);
	
	/**
	 * IBaseDao:
	 * */
	public List<T> findAll();
	
	
	public void pageQuery(PageBean pb);
	/**
	 * IBaseDao:
	 * */
	public T findById(Serializable id);
	
	public void excuteUpdate(String queryName, Object... objs);

	public List<T> findListByDetachedCriteria(DetachedCriteria dc);
}
