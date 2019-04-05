package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.Role;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface IRoleService extends IBaseService<Role>{
	public void pageQuery(PageBean pb);
	public void save(Role role,String ids);
	public List<Role> findAll();
}
