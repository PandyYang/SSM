package com.hw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//系统实例化对象放进spring容器中
@Controller
public class HelloWorldController {
	//在web.xml中国配置的路径 同时符合时 会调用下方的方法
	@RequestMapping("/admin/hi")
	public String helloWorld(Model model) {
		System.out.println("------------->");
		model.addAttribute("message", "hello world!");
		return "hello";
	}
	
	//给出参数则自动servet传给你 然后servlet 的api都可以进行调用
	@RequestMapping("/admin/hello.htm")
	public void hello(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = resp.getWriter();
		out.println("<h1>hello<h1>");
		out.close();
	}
}
