package pandy.test.c_param;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pandy.test.domain.User;
//模型驱动
public class Demo10Action extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return SUCCESS;
	}
	//将参数封装成对象  那么就将其返回
	public User getModel() {
		
		return user;
	}
	
	
}
