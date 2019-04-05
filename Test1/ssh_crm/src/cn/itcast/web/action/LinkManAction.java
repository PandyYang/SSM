package cn.itcast.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LinkMan linkMan = new LinkMan();
	
	private LinkManService lms;

	

	public String add() throws Exception {
		// TODO Auto-generated method stub
		//1.调用service
		lms.save(linkMan);
		//2.重定向到联系人列表
		return "toList";
	}



	@Override
	public LinkMan getModel() {
		return linkMan;
	}


	
	public void setLms(LinkManService lms) {
		this.lms = lms;
	}


	



	
	
}
