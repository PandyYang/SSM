package com.gyf.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IRegionDao;
import com.gyf.bos.domain.Region;
import com.gyf.bos.service.IRegionService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl extends BaseServiceImpl<Region> implements IRegionService {

	@Autowired
	private IRegionDao regionDao;
	@Override
	public void save(Region entity) {
		// TODO Auto-generated method stub
		regionDao.save(entity);
	}

	@Override
	public List<Region> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

}
