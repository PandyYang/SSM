package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.Subarea;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface ISubareaService extends IBaseService<Subarea>{

	public void pageQuery(PageBean pageBean);
	public List<Subarea> findAll();
	
	public List<Subarea> findListNoAssociation();
}
