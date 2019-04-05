package pandy.test.springmvc.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器将String类型 转换成date类型
 * 转换日期类型的数据
 * @author ASUS
 *要想在springmvc中进行conveters的注入 需要实现接口
 */
public class DateConveter implements Converter<String,Date> {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		try {
			if(null != source) {
				//
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return df.parse(source);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}



}
