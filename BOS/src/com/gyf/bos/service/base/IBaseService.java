package com.gyf.bos.service.base;

import java.util.List;

public interface IBaseService<T> {

	public void save(T entity);
	/**
	 * 所有列表数据
	 * */
	public List<T> list();
}
