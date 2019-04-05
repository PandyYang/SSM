package com.gyf.bos.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyf.bos.dao.IWorkOrderManageDao;
import com.gyf.bos.domain.WorkOrderManage;
import com.gyf.bos.service.IWorkOrderManageService;
import com.gyf.bos.service.base.BaseServiceImpl;

@Service
@Transactional
public class WorkOrderManageServiceImpl extends BaseServiceImpl<WorkOrderManage> implements IWorkOrderManageService{

	@Autowired
	private IWorkOrderManageDao workOrderManageDao;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	@Override
	public void save(WorkOrderManage entity) {
		// TODO Auto-generated method stub
		entity.setUpdatetime(new Date());
		workOrderManageDao.save(entity);
	}

	@Override
	public List<WorkOrderManage> list() {
		return null;
	}

	@Override
	public List<WorkOrderManage> findListNoStart() {
		
		DetachedCriteria dc = DetachedCriteria.forClass(WorkOrderManage.class);
		dc.add(Restrictions.eq("start", "0"));
		
	
		
		return workOrderManageDao.findListByDetachedCriteria(dc);
	}

	@Override
	public void start(String id) {
		// TODO Auto-generated method stub
		//1.更改工作单状态为启动
		WorkOrderManage wom = workOrderManageDao.findById(id);
		wom.setStart("1");
		
		//2.启动流程实例
		String pdKey = "transfer";
		String bKey = wom.getId();
		Map<String,Object> vars = new HashMap<String,Object>();
		vars.put("业务数据", wom);
		
		runtimeService.startProcessInstanceByKey(pdKey, bKey,vars);
	}

	@Override
	public WorkOrderManage findById(String bk) {
		// TODO Auto-generated method stub
		return workOrderManageDao.findById(bk);
	}

	@Override
	public void checkWorkOrderManager(String check, String taskId, String id) {
		// TODO Auto-generated method stub
		//1.取出任务【一定要先取出来】
		Task task =taskService.createTaskQuery().taskId(taskId).singleResult();
		String pii = task.getProcessInstanceId();
		//2.办理任务
		Map<String,Object> vars = new HashMap<String,Object>();
		vars.put("check", check);
		taskService.complete(taskId, vars);
		if(check.equals("0")){
			//3.更改状态
			workOrderManageDao.findById(id).setStart("0");
			//4.删除流程实例
			historyService.deleteHistoricProcessInstance(pii);
		}
	}
	
}
