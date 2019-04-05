package com.gyf.bos.service.impl;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IRoleDao;
import com.gyf.bos.dao.IUserDao;
import com.gyf.bos.domain.Role;
import com.gyf.bos.domain.User;
import com.gyf.bos.service.IUserService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.MD5Utils;
import com.gyf.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IdentityService identityService;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		String pwd = model.getPassword();
		pwd = MD5Utils.md5(pwd);
		return this.userDao.findByUsernameAndPassword(model.getUsername(),pwd);
	}

	@Override
	public void editPassword(String newPwd, String id) {
		// TODO Auto-generated method stub
		this.userDao.excuteUpdate("editPassword", newPwd,id);
	}

	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pageQuery(PageBean pb) {
		// TODO Auto-generated method stub
		userDao.pageQuery(pb);
	}

	@Override
	public void add(User user, String[] roleIds) {
		// TODO Auto-generated method stub
		//1.加密密码
		String pwd = user.getPassword();
		pwd = MD5Utils.md5(pwd);
		user.setPassword(pwd);
		
		//2.保存
		userDao.save(user);
		
		//同步到activiti的用户表中
		org.activiti.engine.identity.User actUser = new UserEntity();
		actUser.setId(user.getId());
		identityService.saveUser(actUser);
		
		//3.关联角色
		if(roleIds == null)return;
		for(String roleId : roleIds){
			//Role role = new Role(roleId);
			Role role = roleDao.findById(roleId);
			
			user.getRoles().add(role);
			//关联组和用户
			identityService.createMembership(actUser.getId(), role.getName());
		}
	}

}
