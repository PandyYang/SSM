package com.gyf.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IDecidedZoneDao;
import com.gyf.bos.dao.ISubareaDao;
import com.gyf.bos.domain.DecidedZone;
import com.gyf.bos.domain.Subarea;
import com.gyf.bos.service.IDecidedZoneService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.PageBean;
@Service
@Transactional
public class DecidedZoneServiceImpl extends BaseServiceImpl<DecidedZone> implements IDecidedZoneService {

	@Autowired
	private IDecidedZoneDao decidedZoneDao;
	
	@Autowired
	private ISubareaDao subareaDao;
	@Override
	public void save(DecidedZone entity) {}

	@Override
	public List<DecidedZone> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DecidedZone model, String[] subareaid) {
		// TODO Auto-generated method stub
		//保存定区
		decidedZoneDao.save(model);
		
		//设置子分区已经有人负责了
		for(String id : subareaid){
			Subarea subarea = subareaDao.findById(id);//持久对象
			subarea.setDecidedZone(model);
		}
	}

	@Override
	public void pageQuery(PageBean pb) {
		// TODO Auto-generated method stub
		decidedZoneDao.pageQuery(pb);
	}

}
