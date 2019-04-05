package com.taotao.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper mapper;
	@Override
	public String queryNow() {
		// TODO Auto-generated method stub
		//1.注入mapper
		//2.调用mapper的方法然后返回
		return mapper.queryNow();
	}

}
