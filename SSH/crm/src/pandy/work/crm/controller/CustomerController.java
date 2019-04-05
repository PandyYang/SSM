package pandy.work.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pandy.work.crm.pojo.BaseDict;
import pandy.work.crm.pojo.Customer;
import pandy.work.crm.pojo.QueryVo;
import pandy.work.crm.service.BaseDictService;
import pandy.work.crm.service.CustomerService;
import pandy.work.crm.utils.Page;

/**
 * @author ASUS
 *客户管理
 */
@Controller
public class CustomerController {
	/*
	 * 注解在成员变量上的方式
	 * @Value("${formType.code}")
	 * private String fromTypeCode;
	 * 相应的读取方式变成一下的形式
	 * List<BaseDict>  formType = baseDictService.selectBaseDictByCode(fromTypeCode);
	 * */
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model) {
		//客户名称
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		//客户行业
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		//客户级别
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		return "customer";
	}
	//弹出修改页面
	//@ResponseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为
	//指定的格式之后 写入到response对象的body区 通常用来返回json或者xml数据格式
	//以下的书写方式是将数据直接以json格式返回到前台页面
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	//修改
	@RequestMapping(value="/customer/update.action")
	public void update(Customer customer) {
		customerService.updateCustomerById(customer);
	}
	//删除
	@RequestMapping(value="/customer/delete.action")
	public void deleteCustomerById(Integer id) {
		customerService.deleteCustomerById(id);
	}
}
