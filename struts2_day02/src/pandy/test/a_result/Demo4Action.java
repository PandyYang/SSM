package pandy.test.a_result;

import com.opensymphony.xwork2.ActionSupport;
//如何在action中获得原生的action
public class Demo4Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo4Action!");
		return SUCCESS;
	}
	
}
