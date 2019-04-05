package pandy.test.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import pandy.test.bean.User;

//展示ognl 的语法
public class Demo {
	@Test
	//取出root中的属性值
	public void fun1() throws OgnlException {
		//准备OGNLContext
			//准备Root
			User rootUser= new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String, User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",12));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
			String name = (String) Ognl.getValue("name", oc,oc.getRoot());
			Integer age = (Integer) Ognl.getValue("age", oc,oc.getRoot());
			System.out.println(name);
			System.out.println(age);
			
	}	
	@Test
	//取出context中的属性值
	public void fun2() throws OgnlException {
		//准备OGNLContext
		//准备Root
		User rootUser= new User("tom",18);
		//准备Context
		Map<String,User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",12));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		String name = (String) Ognl.getValue("#user1.name", oc,oc.getRoot());
		String name2 = (String) Ognl.getValue("#user2.name", oc,oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#user1.age", oc,oc.getRoot());
		Integer age2 = (Integer) Ognl.getValue("#user2.age", oc,oc.getRoot());
		System.out.println(name);
		System.out.println(age);
		System.out.println(name2);
		System.out.println(age2);
	}
		@Test
		//为属性赋值
		public void fun3() throws OgnlException {
			//准备OGNLContext
			//准备Root
			User rootUser= new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String, User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",12));
			OgnlContext oc = new OgnlContext();
			oc.setRoot(rootUser);
			oc.setValues(context);
			//书写OGNL
			Ognl.getValue("name='pandy'", oc,oc.getRoot());
			String name = (String) Ognl.getValue("name", oc,oc.getRoot());
			String name2 = (String) Ognl.getValue("#user1.name='lsj',#user1.name", oc, oc.getRoot());
			System.out.println(name);
			System.out.println(name2);
	}	
		@Test
		//为属性赋值
		public void fun4() throws OgnlException {
			//准备OGNLContext
			//准备Root
			User rootUser= new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String, User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",12));
			OgnlContext oc = new OgnlContext();
			oc.setRoot(rootUser);
			oc.setValues(context);
			//书写OGNL
			Ognl.getValue("setName('lilei')",oc,oc.getRoot());
			String name = (String) Ognl.getValue("getName()",oc,oc.getRoot());
			String name2 = (String) Ognl.getValue("#user1.setName('lucy'),#user1.getName()",oc,oc.getRoot());
			System.out.println(name);
			System.out.println(name2);
		}	
@Test
//为属性赋值
public void fun5() throws OgnlException {
	//准备OGNLContext
	//准备Root
	User rootUser= new User("tom",18);
	//准备Context
	Map<String,User> context = new HashMap<String, User>();
	context.put("user1", new User("jack",18));
	context.put("user2", new User("rose",12));
	OgnlContext oc = new OgnlContext();
	oc.setRoot(rootUser);
	oc.setValues(context);
	//书写OGNL
	
	String name = (String) Ognl.getValue("@pandy.test.a_ognl.Hahautils@echo('hello,tinyfry')",oc,oc.getRoot());
	System.out.println(name);
}	

	@Test
//ognl创建对象--list|map
	public void fun6() throws OgnlException {
	//准备OGNLContext
	//准备Root
	User rootUser= new User("tom",18);
	//准备Context
	Map<String,User> context = new HashMap<String, User>();
	context.put("user1", new User("jack",18));
	context.put("user2", new User("rose",12));
	OgnlContext oc = new OgnlContext();
	oc.setRoot(rootUser);
	oc.setValues(context);
	//书写OGNL
	Integer size = (Integer) Ognl.getValue("{'tom','jarry','tinyfry','pandy'}.size()", oc,oc.getRoot());
	String name1 = (String) Ognl.getValue("{'111','222','333','444'}[2]", oc,oc.getRoot());
	String name = (String) Ognl.getValue("{'aaaa','bbbb','bbbbbb','dddddddddd'}[0]", oc, oc.getRoot());
	Integer name2 = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());
	String name3 = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
	/*System.out.println(name);
	System.out.println(size);
	System.out.println(name1);*/
	System.out.println(name2);
	System.out.println(name3);
	
	}	
}
