package cn.itcast.service;
//定义接口  并让接口和实现进行分离  这里主要接受一个参数
import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictService {
	//根据数据字典类型字段获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
