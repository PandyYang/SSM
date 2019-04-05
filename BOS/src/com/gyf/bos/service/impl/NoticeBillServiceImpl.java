package com.gyf.bos.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IDecidedZoneDao;
import com.gyf.bos.dao.INoticeBillDao;
import com.gyf.bos.dao.IWorkBillDao;
import com.gyf.bos.domain.DecidedZone;
import com.gyf.bos.domain.NoticeBill;
import com.gyf.bos.domain.Staff;
import com.gyf.bos.domain.WorkBill;
import com.gyf.bos.service.INoticeBillService;
import com.gyf.bos.service.base.BaseServiceImpl;
import com.gyf.crm.service.CustomerService;

@Service
@Transactional
public class NoticeBillServiceImpl extends BaseServiceImpl<NoticeBill> implements INoticeBillService{

	@Autowired
	private INoticeBillDao noticeBillDao;
	@Autowired
	private IWorkBillDao workBillDao;
	@Autowired
	private IDecidedZoneDao decidedZoneDao;
	@Autowired
	private CustomerService customerService;
	@Override
	public void save(NoticeBill entity) {
		// TODO Auto-generated method stub
		//1.保存业务通知单
		noticeBillDao.save(entity);
		
		//2.自动分配工单
		//通过地址找到定区
		String address = entity.getPickaddress();
		String decidedZondId = customerService.findDecidedZoneIdByAddress(address);
		if(decidedZondId != null){
			//设置取件员
			DecidedZone zone =decidedZoneDao.findById(decidedZondId);
			Staff staff = zone.getStaff();
			entity.setStaff(staff);
			//设置分析类型
			entity.setOrdertype("自动");
			//保存工单
			WorkBill workBill = new WorkBill();
			workBill.setNoticeBill(entity);
			workBill.setStaff(staff);
			workBill.setType("新单");//工单类型：新、追、改、销
			workBill.setPickstate("未取件");//取件状态：未取件、取件中、已取件
			workBill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workBill.setAttachbilltimes(0);
			workBill.setRemark(entity.getRemark());
			
			workBillDao.save(workBill);
		}else{
			entity.setOrdertype("人工");
		}
		
	}

	@Override
	public List<NoticeBill> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
