package com.gyf.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.ISubareaDao;
import com.gyf.bos.domain.Subarea;
import com.gyf.bos.service.ISubareaService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl extends BaseServiceImpl<Subarea> implements ISubareaService{

	@Autowired
	private ISubareaDao subareaDao;
	@Override
	public void save(Subarea entity) {
		// TODO Auto-generated method stub
		subareaDao.save(entity);
	}

	@Override
	public List<Subarea> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}

	@Override
	public List<Subarea> findListNoAssociation() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		dc.add(Restrictions.isNull("decidedZone"));
		return subareaDao.findListByDetachedCriteria(dc);
	}



}
