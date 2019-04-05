package cn.itcast.service.impl;

import org.springframework.dao.support.DaoSupport;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao lmd;
	@Override
	public void save(LinkMan linkMan) {
		// TODO Auto-generated method stub
		lmd.save(linkMan);
	}
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	
}
