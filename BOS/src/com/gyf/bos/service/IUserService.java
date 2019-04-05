package com.gyf.bos.service;

import com.gyf.bos.domain.User;
import com.gyf.bos.service.base.IBaseService;
import com.gyf.bos.utils.PageBean;

public interface IUserService extends IBaseService<User>{

	public User login(User model);
	
	public void editPassword(String newPwd,String id);
	public void pageQuery(PageBean pb);
	
	public void add(User user,String[] roleIds);
}
