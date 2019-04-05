package com.gyf.bos.web.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.gyf.bos.domain.Region;
import com.gyf.bos.domain.Subarea;
import com.gyf.bos.service.ISubareaService;
import com.gyf.bos.web.action.base.BaseAction;

@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{

	private static final long serialVersionUID = 1L;
	
	
	public String add(){
		subareaService.save(model);
		return "list";
	}
	
	public void exportXls() throws IOException{
		 List<Subarea> subareas = subareaService.findAll();//查询所有的分区
		 
		 //1 创建文档对象
		 HSSFWorkbook wk = new HSSFWorkbook();
		 
		 //2 创建sheet
		 HSSFSheet hs = wk.createSheet("分区数据");
		 //3 创建标题行
		 HSSFRow row = hs.createRow(0);
		 row.createCell(0).setCellValue("分区编号");
		 row.createCell(1).setCellValue("区域编号");
		 row.createCell(2).setCellValue("关键字");
		 row.createCell(3).setCellValue("省市区");
		
		 //4 插入遍历数据
		 for(Subarea s : subareas){
			 row = hs.createRow(hs.getLastRowNum() + 1);
			 row.createCell(0).setCellValue(s.getId());
			 row.createCell(1).setCellValue(s.getRegion().getId());
			 row.createCell(2).setCellValue(s.getAddresskey());
			 String str = s.getRegion().getProvince() + s.getRegion().getCity() + s.getRegion().getDistrict();
			 row.createCell(3).setCellValue(str);
		 }
		 
		 //5 响应客户端 
		 //使用utf-8编码文件名
		 String fileName = URLEncoder.encode("分区数据.xls", "UTF-8");
		
		 //一个流两个头
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
		
		// 附件头
		ServletActionContext.getResponse().setContentType(contentType);
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+fileName);
		wk.write(out);
	}
	
	public void pageQuery() throws IOException{
		//所有参数会提交到model中
		String addresskey = model.getAddresskey();//关系字
		Region region = model.getRegion();//地区
		
		//查询条件
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		if(StringUtils.isNoneBlank(addresskey)){//不为空对象或者空字符串
			//添加模糊查询条件
			dc.add(Restrictions.like("addresskey", "%" +addresskey + "%"));
		}
		
		if(region != null){
			//创建别名
			dc.createAlias("region", "r");
			
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			if(StringUtils.isNotBlank(province)){
				dc.add(Restrictions.like("r.province", "%" +province + "%"));
			}
			
			if(StringUtils.isNotBlank(city)){
				dc.add(Restrictions.like("r.city", "%" +city + "%"));
			}
			
			if(StringUtils.isNotBlank(district)){
				dc.add(Restrictions.like("r.district", "%" +district + "%"));
			}
		}
		
		subareaService.pageQuery(pageBean);
		responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas","decidedZone"});
	}
	
	
	public void listjson() throws IOException{
		//返回的子区域必须还没有定区的数据
		List<Subarea> list = subareaService.findListNoAssociation();
		responseJson(list, new String[]{"region","decidedZone"});
	}
}
