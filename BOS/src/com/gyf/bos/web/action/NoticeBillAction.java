package com.gyf.bos.web.action;

import java.io.IOException;

import com.gyf.bos.domain.NoticeBill;
import com.gyf.bos.utils.BosContext;
import com.gyf.bos.web.action.base.BaseAction;
import com.gyf.crm.domain.Customer;

/***
 * 业务通知单
 * @author guoyongfeng
 *
 */
public class NoticeBillAction extends BaseAction<NoticeBill>{

	private String tel;
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	public void findCustomerByTelephone() throws IOException{
		Customer c = customerService.findCustomerByTelephone(tel);
		
		responseJson(c, new String[]{});
	}
	
	public String add(){
		//定单类型，员工，操作员
		//1.设置操作员
		model.setUser(BosContext.getLoginUser());
		System.out.println(this.model);
		noticeBillService.save(model);
		return "nbAdd";
	}
}
