package test03.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.gyf.bos.domain.Region;

public class Test {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		File excelFile = new File("C://课程/JavaEE/物流管理系统项目/day04/资料/区域导入测试数据.xls");
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
			
			Region rg = new Region(id, province, city, district, postcode, null, null, null);
			regions.add(rg);
		}
	}

}
