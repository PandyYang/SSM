package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.Function;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface IFunctionSerivce extends IBaseService<Function>{

	public void pageQuery(PageBean pageBean);
	
	public List<Function> findAll();

	public List<Function> findMenu();
}
