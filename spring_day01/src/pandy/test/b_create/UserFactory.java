package pandy.test.b_create;

import pandy.test.bean.User;

public class UserFactory {
	
	//静态方法直接类名就可以调用方法
	public static User createUser() {
		System.out.println("静态工厂创建");
		return new User();
	}
	//非静态方法必须创建对象  然后进行方法的调用
	public User createUser2() {
		System.out.println("实例工厂创建");
		return new User();
	}
}	
