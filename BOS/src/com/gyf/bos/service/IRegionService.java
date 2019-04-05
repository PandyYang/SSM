package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.Region;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface IRegionService extends IBaseService<Region>{

	public void pageQuery(PageBean pageBean);
	
	public List<Region> findAll();
}
