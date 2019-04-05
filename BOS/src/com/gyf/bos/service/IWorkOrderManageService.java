package com.gyf.bos.service;

import java.util.List;

import com.gyf.bos.domain.WorkOrderManage;
import com.gyf.bos.service.base.IBaseService;

public interface IWorkOrderManageService extends IBaseService<WorkOrderManage>{
	public List<WorkOrderManage> findListNoStart();

	public void start(String id);

	public WorkOrderManage findById(String bk);

	public void checkWorkOrderManager(String check, String taskId, String id);
}
