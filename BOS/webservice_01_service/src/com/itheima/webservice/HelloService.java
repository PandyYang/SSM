package com.itheima.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloService {
	public String sayHello(String name) {
		System.out.println("服务端的sayHello方法被调用");
		return "hello" + name;
	}
	public static void main(String[] args) {
		//服务的地址
		String address = "http://172.19.152.77:8080/hello";
		//服务的提供者
		Object implementor = new HelloService();
		Endpoint.publish(address, implementor);
	}
}
