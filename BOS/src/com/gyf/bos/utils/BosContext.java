package com.gyf.bos.utils;

import org.apache.struts2.ServletActionContext;

import com.gyf.bos.domain.User;

public class BosContext {

	public static User getLoginUser(){
		return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	}
}
