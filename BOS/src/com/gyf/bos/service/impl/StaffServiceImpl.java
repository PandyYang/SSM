package com.gyf.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IStaffDao;
import com.gyf.bos.domain.Staff;
import com.gyf.bos.service.IStaffService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements IStaffService{

	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public List<Staff> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Staff entity) {
		// TODO Auto-generated method stub
		staffDao.save(entity);
	}

	@Override
	public void pageQuery(PageBean pb) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pb);
	}

	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		String[] arr = ids.split(",");
		for(int i = 0; i < arr.length; i++){
			staffDao.excuteUpdate("staff.delete", arr[i]);
		}
		
	}

	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
	}

	@Override
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}
	

	@Override
	public List<Staff> findListNotDelete() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		dc.add(Restrictions.ne("deltag", "1"));
		return staffDao.findListByDetachedCriteria(dc);
	}

	
	
}
