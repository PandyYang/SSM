package com.gyf.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gyf.bos.dao.IFunctionDao;
import com.gyf.bos.dao.base.BaseDaoImpl;
import com.gyf.bos.domain.Function;
@Repository
@SuppressWarnings("unchecked")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{

	
	@Override
	public List<Function> findListByUserId(String userId) {
		// TODO Auto-generated method stub
		//DISTINCT去除重复
		String hql = "SELECT DISTINCT f From Function f ";
		hql += "LEFT OUTER JOIN f.roles r ";
		hql += "LEFT OUTER JOIN r.users u ";
		hql += "WHERE u.id = ?";
		return (List<Function>) this.getHibernateTemplate().find(hql,userId);
	}

	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql = "SELECT DISTINCT f From Function f ";
		hql += "LEFT OUTER JOIN f.roles r ";
		hql += "LEFT OUTER JOIN r.users u ";
		hql += "WHERE u.id = ? AND f.generatemenu = '1' ORDER BY f.zindex DESC";
		return (List<Function>) this.getHibernateTemplate().find(hql,id);
	}

	@Override
	public List<Function> findAllMenu() {
		String hql = "From Function f where f.generatemenu = '1' ORDER BY f.zindex DESC";
		return (List<Function>) this.getHibernateTemplate().find(hql);
	}

}
