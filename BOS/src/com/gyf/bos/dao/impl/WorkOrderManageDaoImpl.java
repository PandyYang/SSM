package com.gyf.bos.dao.impl;

import org.hibernate.envers.Audited;
import org.springframework.stereotype.Repository;

import com.gyf.bos.dao.IWorkOrderManageDao;
import com.gyf.bos.dao.base.BaseDaoImpl;
import com.gyf.bos.domain.WorkOrderManage;

@Repository
public class WorkOrderManageDaoImpl extends BaseDaoImpl<WorkOrderManage> implements IWorkOrderManageDao{

}
