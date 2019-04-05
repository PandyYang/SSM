package com.gyf.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.gyf.bos.domain.Region;
import com.gyf.bos.service.IRegionService;
import com.gyf.bos.utils.PinYin4jUtils;
import com.gyf.bos.web.action.base.BaseAction;


@Scope("prototype")
public class RegionAction extends BaseAction<Region>{

	private static final long serialVersionUID = 1L;
	
	//Struts默认会处理接收到的文件，存储在一个file属性中
	private File excelFile;
	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public String importExcel() throws IOException{
		System.out.println(excelFile.getAbsolutePath());
		
		String flag = "1";
		try {
			//1.Excel对象
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(excelFile));
			
			//2.获取第一个sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			List<Region> regions = new ArrayList<Region>();
			//3.遍历行，获取 cell
			for(Row row : sheet){
				System.out.println(row.getRowNum());
				if(row.getRowNum() == 0){//第一行不遍历
					continue;
				}
				
				String id = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postcode = row.getCell(4).getStringCellValue();
				
				//汉字转拼音
				String[] strToPinYins = PinYin4jUtils.stringToPinyin(city);
				String citycode = StringUtils.join(strToPinYins, "");
				
				//获取字符串的首字母
				province = province.substring(0, province.length() - 1);
				district = district.substring(0, district.length() - 1);
				String totalName = province + city + district;
				String[] tmps = PinYin4jUtils.getHeadByString(totalName);
				String shortcode = StringUtils.join(tmps, "");

				
				
				Region rg = new Region(id, province, city, district, postcode, shortcode, citycode, null);
				regions.add(rg);
			}
			
			//保存到数据库
			for(Region r : regions){
				regionService.save(r);
			}
			
		}catch (Exception e) {
			flag = "0";
			
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(flag);//不要加换行
		
		return NONE;
	}
	
	//分页查询
	public void pageQuery() throws IOException {
			
		//2通过service查询分页数据
		regionService.pageQuery(pageBean);
		
		responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas"});
		
	}
	
	
	public void listjson() throws IOException{
		List<Region>  regions = regionService.findAll();
		responseJson(regions, new String[]{"subareas"});
	}
	
}
