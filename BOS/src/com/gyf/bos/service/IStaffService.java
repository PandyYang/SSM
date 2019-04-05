package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.Staff;
import com.gyf.bos.domain.User;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface IStaffService extends IBaseService<Staff>{

	public void pageQuery(PageBean pb);
	
	public void update(Staff model);
	
	//批量处理
	public void deleteBatch(String ids);
	
	public Staff findById(String id);
	
	public List<Staff> findListNotDelete();
}
