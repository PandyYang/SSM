package cn.itcast.service.impl;

/*在这个层中对dao层进行调用，使用此类中的方法希望返回一个dao层的一个同样的方法
 * 注意定义了dao层中的对象  对这个对象进行set方式注入
 * 
 * */

import java.util.List;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

public class BaseDictServicempl implements BaseDictService {
	private BaseDictDao bdd;
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return bdd.getListByTypeCode(dict_type_code);
	}
	
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
}
