package pandy.test.d_config;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport {
	private String name;
	@Override
	public String execute() throws Exception {
		name="jerry";//从数据库中查询
		System.out.println("Demo3Action");
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
