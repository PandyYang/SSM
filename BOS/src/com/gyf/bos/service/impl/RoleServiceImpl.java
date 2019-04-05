package com.gyf.bos.service.impl;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IRoleDao;
import com.gyf.bos.domain.Function;
import com.gyf.bos.domain.Role;
import com.gyf.bos.service.IRoleService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService{

	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IdentityService identityService;
	@Override
	public void save(Role entity) {
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role role, String ids) {
		// TODO Auto-generated method stub
		//保存角色到activiti的组中,id设置角色名称即可
		GroupEntity group = new GroupEntity(role.getName());
		identityService.saveGroup(group);
		
		//保存角色
		roleDao.save(role);
		String[] idsArr = ids.split(",");
		for(String id : idsArr){
			Function fun = new Function(id);
			//关联权限
			role.getFunctions().add(fun);
		}
		
	}

	@Override
	public void pageQuery(PageBean pb) {
		// TODO Auto-generated method stub
		roleDao.pageQuery(pb);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
