package cn.itcast.web.action;


/*这个层中的功能就是接受service接受过来的数据并以json的格式进行处理，直接反馈到浏览器中*/

//表示层调用控制层 控制层调用业务层 业务层调用数据访问层
//jsp--action--service--dao
/*
* action是业务层的一部分 引用service层 并结合struts2的配置文件 他能跳转到指定的页面也能接受页面传输过来的一些数据进行简单的一些计算
* service层引用dao层数据库操作  编写代码进行一些简单的业务判断
* dao层是数据库访问层  用来对数据库进行一些持久化的操作
* domain层 对应数据库表中的实体类
*/

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.Customer;
import cn.itcast.domain.User;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;
import net.sf.json.JSONArray;
//模型驱动
public class BaseDictAction extends ActionSupport{
	
	private String dict_type_code;//这是接收的数据
	private BaseDictService baseDictService;//定义私有域中的类以及对象
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//1.调用service 根据typeCode获得数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2.将list转换成json格式
		String json = JSONArray.fromObject(list).toString();
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		//不需要进行结果处理
		return null;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
}

