package com.gyf.bos.dao;

import java.util.List;

import com.gyf.bos.dao.base.IBaseDao;
import com.gyf.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function>{

	public List<Function> findListByUserId(String userId);

	public List<Function> findMenuByUserId(String id);

	public List<Function> findAllMenu();
}
