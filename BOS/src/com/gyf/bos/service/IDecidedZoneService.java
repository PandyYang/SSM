package com.gyf.bos.service;


import com.gyf.bos.domain.DecidedZone;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;


public interface IDecidedZoneService extends IBaseService<DecidedZone>{

	public void save(DecidedZone model,String[] subareaid);
	
	public void pageQuery(PageBean pb);
}
