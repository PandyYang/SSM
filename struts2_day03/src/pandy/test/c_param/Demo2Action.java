package pandy.test.c_param;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import pandy.test.bean.User;

public class Demo2Action extends ActionSupport implements ModelDriven<User>{
	/**
	 * 实现模型驱动只需在赋值前，将接收参数的对象压入栈顶即可。
	 */
	private static final long serialVersionUID = 1L;
	private User u = new User();

	@Override
	public String execute() throws Exception {
		
		System.out.println(u);
		return SUCCESS;
	}

/*	public void prepare() throws Exception { //prepare会在拦截器之前进行调用
		// TODO Auto-generated method stub
		//1.压入栈顶 进行接收
		//获得值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		//将u压入栈顶
		vs.push(u);
	}*/

	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	
	
}
