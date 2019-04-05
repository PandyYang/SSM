package com.gyf.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.gyf.bos.domain.DecidedZone;
import com.gyf.bos.service.IDecidedZoneService;
import com.gyf.bos.web.action.base.BaseAction;
import com.gyf.crm.domain.Customer;
import com.gyf.crm.service.CustomerService;
@Scope("prototype")
public class DecidedZoneAction extends BaseAction<DecidedZone>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String [] subareaid;
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	public String save(){
		decidedZoneService.save(model, subareaid);
		return "list";
	}
	
	
	public void pageQuery() throws IOException{
		decidedZoneService.pageQuery(pageBean);
		/**
		 * 注意事项：
		 * 1.需要设置DecidedZone的staff为非懒加载
		 * 2.排序DecidedZone中的detachedCriteria,decidedZones,subareas防止循环引用
		 * */
		responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedZones","subareas"});
	}
	
	
	
	/**
	 * 未关联的客户
	 * @throws IOException 
	 * */
	public void findnoassociationCustomers() throws IOException{
		List<Customer> cus = customerService.findnoassociationCustomers();
		responseJson(cus, new String[]{});
	}
	
	public void findhasAssociationCustomers() throws IOException{
		List<Customer> cus = customerService.findhasassociationCustomers(model.getId());
		responseJson(cus, new String[]{});
	}
	
	
	//关联客户的所有id
	private Integer[] customerIds;
	public void setCustomerIds(Integer[] customerIds) {
		this.customerIds = customerIds;
	}

	public String assigncustomerstodecidedzone(){
		//关联客户
		customerService.assignCustomersToDecidedZone(customerIds, model.getId());
		return "list";
	}
}
