package pandy.test.b_showvs;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("Demo1Action");
		return SUCCESS;
	}
	
}
