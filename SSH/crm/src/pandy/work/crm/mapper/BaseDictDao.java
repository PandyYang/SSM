package pandy.work.crm.mapper;

import java.util.List;

import pandy.work.crm.pojo.BaseDict;

public interface BaseDictDao {
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
	
}
