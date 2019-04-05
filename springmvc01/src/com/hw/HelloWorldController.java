package com.hw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//ϵͳʵ��������Ž�spring������
@Controller
public class HelloWorldController {
	//��web.xml�й����õ�·�� ͬʱ����ʱ ������·��ķ���
	@RequestMapping("/admin/hi")
	public String helloWorld(Model model) {
		System.out.println("------------->");
		model.addAttribute("message", "hello world!");
		return "hello";
	}
	
	//�����������Զ�servet������ Ȼ��servlet ��api�����Խ��е���
	@RequestMapping("/admin/hello.htm")
	public void hello(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = resp.getWriter();
		out.println("<h1>hello<h1>");
		out.close();
	}
}
