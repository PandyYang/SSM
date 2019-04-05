package pandy.work.crm.service;

import java.util.List;

import pandy.work.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictListByCode(String code);
}
