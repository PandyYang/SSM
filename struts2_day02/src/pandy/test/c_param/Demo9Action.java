package pandy.test.c_param;



import com.opensymphony.xwork2.ActionSupport;

import pandy.test.domain.User;

public class Demo9Action extends ActionSupport {
	
	private  User user;
	public String execute() throws Exception{
		
		System.out.println(user);
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
