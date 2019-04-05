package com.pandy.utils;

import java.util.UUID;

/**
* @author Pandy
* @version 2018年11月14日 下午7:48:26
*
*/
public class CommonsUtils {
	//生成uuid的方法
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
