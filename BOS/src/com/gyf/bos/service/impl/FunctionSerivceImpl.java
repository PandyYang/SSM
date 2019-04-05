package com.gyf.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IFunctionDao;
import com.gyf.bos.domain.Function;
import com.gyf.bos.domain.User;
import com.gyf.bos.service.IFunctionSerivce;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.BosContext;
import com.gyf.bos.utils.PageBean;


@Service
@Transactional
public class FunctionSerivceImpl extends BaseServiceImpl<Function> implements IFunctionSerivce{

	@Autowired
	private IFunctionDao functionDao;
	@Override
	public void save(Function entity) {
		// TODO Auto-generated method stub
		functionDao.save(entity);
	}

	@Override
	public List<Function> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		functionDao.pageQuery(pageBean);
	}

	@Override
	public List<Function> findAll() {
		// TODO Auto-generated method stub
		return functionDao.findAll();
	}

	@Override
	public List<Function> findMenu() {
		// TODO Auto-generated method stub
		User user = BosContext.getLoginUser();
		if(user.getUsername().equals("admin")){
			return functionDao.findAllMenu();
		}else{
			return functionDao.findMenuByUserId(user.getId());
		}
		
	}

	
}
