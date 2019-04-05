package test04.pinyin4j;

import org.apache.commons.lang3.StringUtils;

import com.gyf.bos.utils.PinYin4jUtils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String province = "山西省";
		String city = "太原市";
		String district = "清徐县";
		
		//汉字转拼音
		String[] strToPinYins = PinYin4jUtils.stringToPinyin(city);
		String strToPinYin = StringUtils.join(strToPinYins, "");
		System.out.println(strToPinYin);
		
		//获取字符串的首字母
		province = province.substring(0, province.length() - 1);
		district = district.substring(0, district.length() - 1);
		String totalName = province + city + district;
		String[] tmps = PinYin4jUtils.getHeadByString(totalName);
		String shortcode = StringUtils.join(tmps, "");
		System.out.println(shortcode);
	}

}
