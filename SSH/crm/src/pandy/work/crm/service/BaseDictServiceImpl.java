package pandy.work.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandy.work.crm.mapper.BaseDictDao;
import pandy.work.crm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	public List<BaseDict> selectBaseDictListByCode(String code){
		return baseDictDao.selectBaseDictListByCode(code);
		
	}
}
